package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.UserTokenEntity;
import com.example.demo.mysql.repository.UserTokenEntityRepository;
import com.example.demo.mysql.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service("userTokenServiceImpl")
public class UserTokenServiceImpl implements UserTokenService {

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
    public int deleteByUserIdAndRefToken(long id, String refreshToken) {
        return userTokenEntityRepository.deleteByUsername(id, refreshToken);
    }

    @Override
    public Optional<UserTokenEntity> insertUserToken(UserTokenEntity userTokenEntity) {
        UserTokenEntity tokenEntity = userTokenEntityRepository.save(userTokenEntity);
        return Optional.of(tokenEntity);
    }

    @Override
    public boolean verifyTokenAvailable(Optional<UserTokenEntity> userTokenEntity) {
        if (!userTokenEntity.isPresent()) {
            return false;
        }
        UserTokenEntity userToken = userTokenEntity.get();
        Timestamp tokenExpiry = userToken.getTokenExpiry();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (now.before(tokenExpiry)) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean verifyRefreshTokenAvailable(Optional<UserTokenEntity> userTokenEntity) {
        if (!userTokenEntity.isPresent()) {
            return false;
        }
        UserTokenEntity userToken = userTokenEntity.get();
        Timestamp refreshTokenExpiry = userToken.getRefreshTokenExpiry();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (now.before(refreshTokenExpiry)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<UserTokenEntity> updateToken(long id, String refreshToken) {
        return Optional.empty();
    }
}
