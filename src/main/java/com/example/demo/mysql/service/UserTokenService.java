package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

public interface UserTokenService {

    List<UserTokenEntity> findByUserID(long id);

    Optional<UserTokenEntity> findByUserIDAndToken(long id, String token);

    int deleteByUserIdAndRefToken(long id, String refreshToken);

    Optional<UserTokenEntity> insertUserToken(UserTokenEntity userTokenEntity);

    boolean verifyTokenAvailable(Optional<UserTokenEntity> userTokenEntity);

    boolean verifyRefreshTokenAvailable(Optional<UserTokenEntity> userTokenEntity);

    Optional<UserTokenEntity> updateToken(long id, String refreshToken, String device);

}
