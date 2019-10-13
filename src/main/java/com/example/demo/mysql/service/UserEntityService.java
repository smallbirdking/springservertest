package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserEntityService {

    List<UserEntity> findAll();

    List<UserEntity> findByUserName(String userName);

    Optional<UserEntity> findOneByUserName(String userName);

    Optional<UserEntity> findByUserId(Long id);

    Optional<UserEntity> insertUser(UserEntity userEntity);

    int deleteByUsername(String username);
}
