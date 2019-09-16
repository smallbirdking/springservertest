package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.UserProfileEntity;

import java.util.List;

public interface UserProfileEntityService {

    List<UserProfileEntity> findByUserID(Long id);
}
