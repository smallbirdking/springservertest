package com.example.demo.mysql.entity;

import com.example.demo.entity.BaseResponse;

import java.util.Date;

public class LoginResponse extends BaseResponse {
    private String accessToken;
    private Date expiresIn;
    private String refreshToken;
    private String userId;
    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
