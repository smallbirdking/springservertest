package com.example.demo.dao;

import com.example.demo.entity.Text;
import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public List<User> findByUserName(String UserName);

    public void addUsers(List<User> users);
}
