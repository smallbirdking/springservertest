package com.example.demo.mysql.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "User_Token", schema = "HeatWave", catalog = "")
public class UserTokenEntity {
    private long id;
    private Long userId;
    private String token;
    private String refreshToken;
    private Timestamp tokenExpiry;
    private Timestamp refreshTokenExpiry;
    private String scope;
    private String oldToken;
    private String device;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "TOKEN")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "REFRESH_TOKEN")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Basic
    @Column(name = "TOKEN_EXPIRY")
    public Timestamp getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(Timestamp tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    @Basic
    @Column(name = "REFRESH_TOKEN_EXPIRY")
    public Timestamp getRefreshTokenExpiry() {
        return refreshTokenExpiry;
    }

    public void setRefreshTokenExpiry(Timestamp refreshTokenExpiry) {
        this.refreshTokenExpiry = refreshTokenExpiry;
    }

    @Basic
    @Column(name = "SCOPE")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTokenEntity that = (UserTokenEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (refreshToken != null ? !refreshToken.equals(that.refreshToken) : that.refreshToken != null) return false;
        if (tokenExpiry != null ? !tokenExpiry.equals(that.tokenExpiry) : that.tokenExpiry != null) return false;
        if (refreshTokenExpiry != null ? !refreshTokenExpiry.equals(that.refreshTokenExpiry) : that.refreshTokenExpiry != null)
            return false;
        if (scope != null ? !scope.equals(that.scope) : that.scope != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (refreshToken != null ? refreshToken.hashCode() : 0);
        result = 31 * result + (tokenExpiry != null ? tokenExpiry.hashCode() : 0);
        result = 31 * result + (refreshTokenExpiry != null ? refreshTokenExpiry.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "OLD_TOKEN")
    public String getOldToken() {
        return oldToken;
    }

    public void setOldToken(String oldToken) {
        this.oldToken = oldToken;
    }

    @Basic
    @Column(name = "DEVICE")
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
