package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.Util.LoginUtil;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.LoginException;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mysql.entity.UserTokenEntity;
import com.example.demo.mysql.repository.UserTokenEntityRepository;
import com.example.demo.mysql.service.UserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("userTokenServiceImpl")
public class UserTokenServiceImpl implements UserTokenService {
    private static final Logger LOG = LoggerFactory.getLogger(UserTokenServiceImpl.class);

    @Autowired
    private UserTokenEntityRepository userTokenEntityRepository;

    @Override
    public List<UserTokenEntity> findByUserID(long id) {
        return userTokenEntityRepository.findByUserID(id);
    }

    @Override
    public Optional<UserTokenEntity> findByUserIDAndToken(long id, String token) {
        return userTokenEntityRepository.findByUserIDAndToken(id, token);
    }

    @Override
    public Optional<UserTokenEntity> findByUserIDAndDevice(long id, String device) {
        return userTokenEntityRepository.findByUserIDAndDevice(id, device);
    }

    @Override
    @Transactional
    public int deleteByUserIdAndRefToken(long id, String refreshToken) {
        return userTokenEntityRepository.deleteByUsername(id, refreshToken);
    }

    @Override
    @Transactional
    public Optional<UserTokenEntity> insertUserToken(UserTokenEntity userTokenEntity) {
        UserTokenEntity tokenEntity = userTokenEntityRepository.save(userTokenEntity);
        return Optional.of(tokenEntity);
    }

    @Override
    public boolean verifyTokenAvailable(Optional<UserTokenEntity> userTokenEntity, String token) {
        if (userTokenEntity.isPresent()) {
            UserTokenEntity userToken = userTokenEntity.get();
            Timestamp tokenExpiry = userToken.getTokenExpiry();
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if (now.before(tokenExpiry)) {
                String checkToken = userToken.getToken();
                String oldToken = userToken.getOldToken();
                if (checkToken.equals(token)){
                    return true;
                } else if (oldToken.equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean verifyRefreshTokenAvailable(Optional<UserTokenEntity> userTokenEntity, String refreshToken) {
        if (userTokenEntity.isPresent()) {
            UserTokenEntity userToken = userTokenEntity.get();
            Timestamp refreshTokenExpiry = userToken.getRefreshTokenExpiry();
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if (now.before(refreshTokenExpiry)) {
                String checkRefreshToken = userToken.getRefreshToken();
                if (checkRefreshToken.equals(refreshToken)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @Transactional
    public Optional<UserTokenEntity> updateToken(long userId, String token, String  refreshToken, String device) {
        Optional<UserTokenEntity> userToken = userTokenEntityRepository.findByUserIDAndRefreshToken(userId, refreshToken);
        if (userToken.isPresent()) {
            if (verifyTokenAvailable(userToken, token)){
                return userToken;
            }
            if (verifyRefreshTokenAvailable(userToken, refreshToken)) {
                Date expire = LoginUtil.generateTokenExpiry();
                Date refreshExpiry = LoginUtil.generateRefreshTokenExpiry();
                String oldToken = userToken.get().getToken();
                UserTokenEntity userTokenEntity = null;
                try {
                    userToken.get().setToken(LoginUtil.generateRefreshToken(userId, expire, device));
                    userToken.get().setTokenExpiry(new Timestamp(expire.getTime()));
                    userToken.get().setOldToken(oldToken);
                    userToken.get().setRefreshTokenExpiry(new Timestamp(refreshExpiry.getTime()));
                    userTokenEntity = userTokenEntityRepository.save(userToken.get());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (userTokenEntity != null) {
                    Optional.of(userTokenEntity);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public long verifyUserAuthen(UserHeader userHeader, BaseResponse response) {
        long userId = userHeader.getUserId();
        String token = userHeader.getToken();
        String refreshToken = userHeader.getRefreshToken();
        String device = userHeader.getDevice();
        Optional<UserTokenEntity> userTokenEntity = findByUserIDAndDevice(userId, device);
        boolean available = verifyTokenAvailable(userTokenEntity, token);

        if (!available && userTokenEntity.isPresent()) {
            try{
                Optional<UserTokenEntity> newUserTokenEntity = updateToken(userTokenEntity.get().getUserId(), token, refreshToken, device);
                if (!newUserTokenEntity.isPresent()) {
                    //Error need login
                    userId = -1;
                    throw new LoginException("NEED LOGIN", "1000");
                }
                response.setCode("0001");
                response.setMsg("NEED REFRESH TOKEN");
                response.setTocken(newUserTokenEntity.get().getToken());
                response.setRefreshtoken(newUserTokenEntity.get().getRefreshToken());
            } catch (Exception e){
                userId = -1;
                LOG.error("verifyUserAuthen error:",e);
            }
        }
        return userId;
    }
}
