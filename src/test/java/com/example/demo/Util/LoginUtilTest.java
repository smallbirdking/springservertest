package com.example.demo.Util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class LoginUtilTest {
    @Test
    public void testGenerateToken() throws UnsupportedEncodingException {
        Long userId = Long.valueOf(1);
        Long userId2 = Long.valueOf(2);
        String token = LoginUtil.generateToken(userId, new Date(),"HuaWei");
        String token2 = LoginUtil.generateToken(userId2, new Date(),"HuaWei");
//        String token3 = LoginUtil.generateToken("sbk1");
        System.out.println(token);
        System.out.println(token2);
//        System.out.println(token3);
    }

    @Test
    public void testGenerateTokenExpiry(){
        Date date = LoginUtil.generateTokenExpiry();
        System.out.println(date);
        Date date2 = LoginUtil.generateRefreshTokenExpiry();
        System.out.println(date2);

    }

}
