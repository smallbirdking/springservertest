package com.example.demo.mysql.controller;

import com.example.demo.Util.LoginUtil;
import com.example.demo.mysql.entity.LoginInfo;
import com.example.demo.mysql.entity.LoginResponse;
import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserTokenEntity;
import com.example.demo.mysql.service.UserEntityService;
import com.example.demo.mysql.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/signin")
public class LoginController {

    public static final String ALL = "ALL";

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private UserTokenService userTokenService;

    @RequestMapping(value = "/username", method = RequestMethod.POST)
    public LoginResponse loginByUsername(@RequestBody LoginInfo loginInfo) {
        LoginResponse response = new LoginResponse();
        Optional<UserEntity> user = userEntityService.findOneByUserName(loginInfo.getUsername());
        if (!user.isPresent()) {
            response.setCode("1001");
            response.setMsg("No User found");
        }
        UserEntity userEntity = user.get();
        String userPassword = userEntity.getUserPassword();
        if (userPassword != null && userPassword.equalsIgnoreCase(loginInfo.getPassword())) {
            try {
                Date expiresIn = LoginUtil.generateTokenExpiry();
                String token = LoginUtil.generateToken(userEntity.getId(), expiresIn, loginInfo.getDevice());
                response.setUserId(""+userEntity.getId());
                response.setAccessToken(token);
                response.setExpiresIn(expiresIn);
                Date refreshExpiry = LoginUtil.generateRefreshTokenExpiry();
                String refreshToken = LoginUtil.generateRefreshToken(userEntity.getId(), refreshExpiry, loginInfo.getDevice());
                response.setRefreshToken(refreshToken);

                Optional<UserTokenEntity> userTokenOriginal = userTokenService.findByUserIDAndDevice(userEntity.getId(), loginInfo.getDevice());

                UserTokenEntity userToken = userTokenOriginal.isPresent() ? userTokenOriginal.get() : new UserTokenEntity();

                //UserTokenEntity userToken = new UserTokenEntity();
                userToken.setUserId(userEntity.getId());
                userToken.setToken(LoginUtil.generateToken(userEntity.getId(), expiresIn, loginInfo.getDevice()));
                userToken.setTokenExpiry(new Timestamp(expiresIn.getTime()));
                userToken.setRefreshToken(LoginUtil.generateRefreshToken(userEntity.getId(), refreshExpiry, loginInfo.getDevice()));
                userToken.setRefreshTokenExpiry(new Timestamp(refreshExpiry.getTime()));
                userToken.setScope(ALL);
                userToken.setDevice(loginInfo.getDevice());
                userTokenService.insertUserToken(userToken);

            } catch (UnsupportedEncodingException e) {
                response.setCode("1003");
                response.setMsg("New token failed");
            }
        } else {
            response.setCode("1002");
            response.setMsg("Wrong password");
        }
        return response;
    }
}
