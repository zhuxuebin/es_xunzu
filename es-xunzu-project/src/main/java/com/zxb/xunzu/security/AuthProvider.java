package com.zxb.xunzu.security;

import com.zxb.xunzu.entity.User;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 自定义认证实现
 * Created by xuery on 2018/5/10.
 */
public class AuthProvider implements AuthenticationProvider {

    //Md5加密器
    private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName(); //输入用户名
        String inputPassword = (String) authentication.getCredentials(); //输入密码

        User user = new User();
        user.setPassword("");

        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("authError");
        }

        if (this.passwordEncoder.isPasswordValid(user.getPassword(), inputPassword, user.getId())){
            //验证通过,则返回user信息和user拥有的权限列表
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorityList());
        }
        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
