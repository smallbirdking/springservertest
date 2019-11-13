package com.example.demo.mongodb.entity;

public class UserHeader {
    long userId;
    String token;
    String device;
    String refreshToken;

    public UserHeader(long userId, String token, String device, String refreshToken) {
        this.userId = userId;
        this.token = token;
        this.device = device;
        this.refreshToken = refreshToken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
