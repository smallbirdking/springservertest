package com.example.demo.mysql;

import com.example.demo.Util.LoginUtil;
import com.example.demo.mysql.entity.UserTokenEntity;
import com.example.demo.mysql.service.UserTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTokenEntityTest {
    @Autowired
    private UserTokenService userTokenService;

    @Test
    public void testSaveUserToken() throws UnsupportedEncodingException {
        long id = 1;
        Date expires = LoginUtil.generateTokenExpiry();
        Date refreshExpiry = LoginUtil.generateRefreshTokenExpiry();
        UserTokenEntity userToken = new UserTokenEntity();
        userToken.setUserId(id);
        userToken.setToken(LoginUtil.generateToken(id, expires, "huawei"));
        userToken.setTokenExpiry(new Timestamp(expires.getTime()));
        userToken.setRefreshToken(LoginUtil.generateRefreshToken(id, refreshExpiry, "huawei"));
        userToken.setRefreshTokenExpiry(new Timestamp(refreshExpiry.getTime()));
        userToken.setScope("ALL");

        userTokenService.insertUserToken(userToken);
    }





}
