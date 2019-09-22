package com.example.demo.mongodb;


import com.example.demo.mongodb.dao.ThreadDao;
import com.example.demo.mongodb.dao.UserDao;
import com.example.demo.mongodb.dao.UserProfileDao;
import com.example.demo.mongodb.entity.Thread;
import com.example.demo.mongodb.entity.User;
import com.example.demo.mongodb.entity.UserProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertDataTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private ThreadDao threadDao;

    @Test
    public void testInsertUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date createdTime = new Date();

        System.out.println("date: "+df.format(createdTime));

        user1.setCreatedTime(createdTime);
        user1.setCreatedBy("Computer");
        user1.setUserName("YUQIWANG");
        user1.setUserPassword("123");


        user2.setCreatedTime(createdTime);
        user1.setCreatedBy("Computer");
        user1.setUserName("ZHEZHOU");
        user1.setUserPassword("123");

        System.out.println("size: "+users.size());
        userDao.addUsers(users);
    }

    @Test
    public void testInsertUserProfile() {
        List<User> users = userDao.findByUserName("YUQIWANG");
        if (!users.isEmpty()){
            User user = users.get(0);
            UserProfile userProfile = new UserProfile();


        }
    }


    @Test
    public void testInsertThread() {
        long userId = 1;
        List<Long> admins = new ArrayList<>();
        admins.add(userId);
        Date createdTime = new Date();

        Thread thread = new Thread();
        thread.setAdminList(admins);
        thread.setTrSubject("Test");
        thread.setTrBody("tests");
        thread.setCreatedUserId(userId);
        thread.setCreatedTime(createdTime);
        threadDao.save(thread);
    }

    @Test
    public void getThreadByUserId() {
        long userId = 1;
        List<Thread> threads = threadDao.findByUserId(userId);
        System.out.println(threads);
    }

}
