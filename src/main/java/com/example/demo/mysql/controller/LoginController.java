package com.example.demo.mysql.controller;

import com.example.demo.Util.LoginUtil;
import com.example.demo.mysql.entity.LoginInfo;
import com.example.demo.mysql.entity.LoginResponse;
import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.service.UserEntityService;
import com.example.demo.mysql.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;


@Controller
@RequestMapping("/login")
public class LoginController {
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
                String refreshToken = LoginUtil.generateToken(userEntity.getId(), expiresIn, loginInfo.getDevice());
                response.setRefreshToken(refreshToken);


//                java.util.Date utilDate = new java.util.Date(sqlDate.getTime());   // sql -> util
//                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());   // util -> sql
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
