package com.example.demo.mysql;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.service.UserEntityService;
import com.example.demo.mysql.service.UserProfileEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTest {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private UserProfileEntityService userProfileEntityService;


    @Test
    public void testfindAllUsers() {
        List<UserEntity> allUsers =  userEntityService.findAll();
        System.out.println(allUsers.get(0));
    }

    @Test
    public void testfindUsersByUserName() {
        List<UserEntity> allUsers =  userEntityService.findByUserName("sbk");
        System.out.println(allUsers.size());
    }

    @Test
    public void testfindUsersByUserID() {
        long id = 1;
        Optional<UserEntity> allUser =  userEntityService.findByUserId(id);
        System.out.println(allUser.get());
    }

    @Test
    public void testfindUserProfileByUserID() {
        List<UserProfileEntity> allUserProfiles =  userProfileEntityService.findByUserID(Long.valueOf(1));
        System.out.println(allUserProfiles.size());
    }

    @Test
    public void testSaveUser() {

        Timestamp time2 = new Timestamp(new Date().getTime());

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("sbk1");
        userEntity.setUserPassword("123");
        userEntity.setCreatedTime(time2);
        userEntityService.insertUser(userEntity);
//        System.out.println(allUser.get());
    }

    @Test
    public void testSaveUserProfile() {
        long id = 1;
        Optional<UserEntity> allUser =  userEntityService.findByUserId(id);
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        userProfileEntity.setFirstName("YU");
        userProfileEntity.setLastName("W");
//        userProfileEntity.setNickName("sbk");
//        userProfileEntity.setPassword("123");
        userProfileEntity.setUserByUserId(allUser.get());
        userProfileEntityService.insertUserProfile(userProfileEntity);
    }

}
