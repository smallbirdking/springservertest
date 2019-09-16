package com.example.demo.mongodb.dao;

import com.example.demo.mongodb.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public List<User> findByUserName(String UserName);

    public void addUsers(List<User> users);
}
