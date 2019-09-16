package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.UserEntity;

import java.util.List;

public interface UserEntityService {

    List<UserEntity> findAll();

    List<UserEntity> findByUserName(String userName);
}
