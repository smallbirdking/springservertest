package com.example.demo.Util;

import com.example.demo.mongodb.entity.UserHeader;

import javax.servlet.http.HttpServletRequest;

public class AuthenUtil {
    public static UserHeader getUserHeader(HttpServletRequest requestHeader) {
        String userIdStr = requestHeader.getHeader("userId");
        long userIdClient = Long.valueOf(userIdStr);
        String token = requestHeader.getHeader("token");
        String refreshToken = requestHeader.getHeader("refreshToken");
        String device = requestHeader.getHeader("device");
        return new UserHeader(userIdClient, token, refreshToken, device);
    }
}
