package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String getPassword(String password) {

        return bCryptPasswordEncoder.encode(password);
    }


    public static void main(String[] args) {
        String password="456";
        System.out.println(getPassword(password));
    }
}
