package com.zxb.xunzu.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by xuery on 2018/5/10.
 */
public class MD5Util {

    private MD5Util(){

    }

    //Md5加密器
    private static final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    public static String Md5(String password, String salt){
        return passwordEncoder.encodePassword(password,salt);
    }

    public static void main(String[] args) {
        System.out.println(Md5("admin","2"));
    }
}
