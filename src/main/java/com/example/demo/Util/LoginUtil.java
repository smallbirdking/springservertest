package com.example.demo.Util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

public class LoginUtil {

    public static final long MINUTE_TTL = 60*1000;  //millisecond
    public static final long HOURS_TTL = 60*60*1000L;  //millisecond
    public static final long DAY_TTL = 24*60*60*1000L;  //millisecond
    public static final long MONTH_TTL = 30*24*60*60*1000L;  //millisecond

    private LoginUtil() {
    }

    public static String generateRefreshToken(Long userId, Date expiresIn, String device) throws UnsupportedEncodingException {
        return generateToken(userId, device, expiresIn, "refresh-token");
    }

    public static String generateToken(Long userId, Date expiresIn, String device) throws UnsupportedEncodingException {
        return generateToken(userId, device, expiresIn, "token");
    }

    private static String generateToken(Long userId, String device, Date currentDate, String type) throws UnsupportedEncodingException {
        String secret = "secret";
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("device", device);
        map.put("curDate", currentDate);
        map.put("type", type);
        String jwt = Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS256, secret.getBytes("UTF-8"))
                .compact();
        return jwt;
    }

    public static Date generateTokenExpiry(){
        return generateTokenExpiry(new Date(), 2*HOURS_TTL);
    }

    public static Date generateRefreshTokenExpiry(){
        return generateTokenExpiry(new Date(), MONTH_TTL);
    }


    public static Date generateTokenExpiry(Date currentDate, long duration){
        if (currentDate == null || duration < 0) {
            return null;
        }
        long time = currentDate.getTime();
        if (time <= 0) {
            return null;
        }
        return new Date(time+duration);
    }
}
