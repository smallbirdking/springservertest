package com.example.demo.mysql.controller;

import com.example.demo.Util.LoginUtil;
import com.example.demo.mysql.entity.LoginInfo;
import com.example.demo.mysql.entity.LoginResponse;
import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserTokenEntity;
import com.example.demo.mysql.service.UserEntityService;
import com.example.demo.mysql.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;


@Controller
@RequestMapping("/login")
public class LoginController {

    public static final String ALL = "ALL";

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private UserTokenService userTokenService;

    @PostMapping(value = "/username")
    public LoginResponse loginByUsername(LoginInfo loginInfo) {
        LoginResponse response = new LoginResponse();
        Optional<UserEntity> user = userEntityService.findOneByUserName(loginInfo.getUsername());
        if (!user.isPresent()) {
            response.setErrcode(101);
            response.setErrmsg("No User found");
        }
        UserEntity userEntity = user.get();
        String userPassword = userEntity.getUserPassword();
        if (userPassword != null && userPassword.equalsIgnoreCase(loginInfo.getPassword())) {
            try {
                Date expiresIn = LoginUtil.generateTokenExpiry();
                String token = LoginUtil.generateToken(userEntity.getId(), expiresIn, loginInfo.getDevice());
                response.setAccessToken(token);
                response.setExpiresIn(expiresIn);
                Date refreshExpiry = LoginUtil.generateRefreshTokenExpiry();
                String refreshToken = LoginUtil.generateRefreshToken(userEntity.getId(), refreshExpiry, loginInfo.getDevice());
                response.setRefreshToken(refreshToken);

                UserTokenEntity userToken = new UserTokenEntity();
                userToken.setUserId(userEntity.getId());
                userToken.setToken(LoginUtil.generateToken(userEntity.getId(), expiresIn, loginInfo.getDevice()));
                userToken.setTokenExpiry(new Timestamp(expiresIn.getTime()));
                userToken.setRefreshToken(LoginUtil.generateRefreshToken(userEntity.getId(), refreshExpiry, loginInfo.getDevice()));
                userToken.setRefreshTokenExpiry(new Timestamp(refreshExpiry.getTime()));
                userToken.setScope(ALL);
                userTokenService.insertUserToken(userToken);

            } catch (UnsupportedEncodingException e) {
                response.setErrcode(103);
                response.setErrmsg("New token failed");
            }
        } else {
            response.setErrcode(102);
            response.setErrmsg("Wrong password");
        }
        return response;
    }
}
