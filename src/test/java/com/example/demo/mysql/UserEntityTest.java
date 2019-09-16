package com.example.demo.mysql;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.service.UserEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTest {

    @Autowired
    private UserEntityService userEntityService;

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

}
