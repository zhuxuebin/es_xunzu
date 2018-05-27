package com.imooc.security;


import com.imooc.base.LoginUserUtil;
import com.imooc.entity.User;
import com.imooc.service.ISmsService;
import com.imooc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by xuery on 2018/5/10.
 */
public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISmsService smsService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //获取表格提交的用户名
        String name = obtainUsername(request);
        if (name != "") {
            request.setAttribute("username", name);
            return super.attemptAuthentication(request, response); //跳转到AuthProvider
        }

        //可能是通过手机号注册登录的
        String telephone = request.getParameter("telephone");
        if (telephone!=null || !LoginUserUtil.checkTelephone(telephone)) {
            throw new BadCredentialsException("wrong telephone number");
        }

        User user = userService.findUserByTelephone(telephone);
        String inputCode = request.getParameter("smsCode");
        String sessionCode = null; //todo xuery
        if (Objects.equals(inputCode, sessionCode)) {
            if (user == null) {
//                user = userService.addUserByTelephone(telephone);
            }
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorityList());
        } else {
            throw new BadCredentialsException("smsCodeError");
        }
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(null, null));
        System.out.println(Objects.equals("", null));
        System.out.println(Objects.equals("  ", null));
        System.out.println(Objects.equals("  ", null));
        System.out.println(Objects.equals("", ""));
        System.out.println(Objects.equals("  ", ""));
    }
}
