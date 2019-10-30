package com.example.demo.mysql.service;

import com.example.demo.entity.BaseResponse;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mysql.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

public interface UserTokenService {

    List<UserTokenEntity> findByUserID(long id);

    Optional<UserTokenEntity> findByUserIDAndToken(long id, String token);

    Optional<UserTokenEntity> findByUserIDAndDevice(long id, String device);

    int deleteByUserIdAndRefToken(long id, String refreshToken);

    Optional<UserTokenEntity> insertUserToken(UserTokenEntity userTokenEntity);

    boolean verifyTokenAvailable(Optional<UserTokenEntity> userTokenEntity, String token);

    boolean verifyRefreshTokenAvailable(Optional<UserTokenEntity> userTokenEntity, String refreshToken);

    Optional<UserTokenEntity> updateToken(long id, String token, String refreshToken, String device);

    long verifyUserAuthen(UserHeader userHeader, BaseResponse response);
}
