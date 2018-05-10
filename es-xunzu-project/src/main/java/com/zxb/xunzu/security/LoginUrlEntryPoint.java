package com.zxb.xunzu.security;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于角色的登录入口控制器
 * Created by xuery on 2018/5/10.
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private PathMatcher pathMatcher = new AntPathMatcher();

    private final Map<String, String> authEntryPointMap;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);

        authEntryPointMap = new HashMap<>();

        //普通用户登录路口映射
        authEntryPointMap.put("/user/**", "/user/login");
        //管理员登录入口映射
        authEntryPointMap.put("/admin/**", "/admin/login");
    }
}
