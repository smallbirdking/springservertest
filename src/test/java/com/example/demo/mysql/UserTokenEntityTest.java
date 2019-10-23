package com.example.demo.mysql;

import com.example.demo.Util.LoginUtil;
import com.example.demo.mysql.entity.UserTokenEntity;
import com.example.demo.mysql.service.UserTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testDeleteUserToken() throws UnsupportedEncodingException {
        long id = 1;
        List<UserTokenEntity> byUserID = userTokenService.findByUserID(id);
        if (!CollectionUtils.isEmpty(byUserID)) {
            UserTokenEntity userTokenEntity = byUserID.get(byUserID.size() - 1);
            int status = userTokenService.deleteByUserIdAndRefToken(id, userTokenEntity.getRefreshToken());
            System.out.println(status);
        }
    }


    @Test
    public void testUpdateUserToken() throws UnsupportedEncodingException {
        long id = 1;
        List<UserTokenEntity> byUserID = userTokenService.findByUserID(id);
        if (!CollectionUtils.isEmpty(byUserID)) {
            String token = byUserID.get(0).getToken();
            Optional<UserTokenEntity> byUserIDAndToken = userTokenService.findByUserIDAndToken(id, token);
            if (byUserIDAndToken.isPresent() && !userTokenService.verifyTokenAvailable(byUserIDAndToken)) {
                Optional<UserTokenEntity> userToken = userTokenService.updateToken(id, byUserIDAndToken.get().getRefreshToken(), "huawei");
            }
        }

    }


}
