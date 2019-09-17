package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.UserProfileEntity;

import java.util.List;
import java.util.Optional;

public interface UserProfileEntityService {

    List<UserProfileEntity> findByUserID(Long id);

    Optional<UserProfileEntity> insertUserProfile(UserProfileEntity userProfileEntity);
}
