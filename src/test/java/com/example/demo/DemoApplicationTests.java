package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
    }


    /**
     * 根据name查询User
     */
    @Test
    public void TestFindByName(){
        List<User> users = userDao.findAll();
        System.out.println("size: "+users.size());
        //System.out.println("user1: "+users.get(0).getName());
    }


}
