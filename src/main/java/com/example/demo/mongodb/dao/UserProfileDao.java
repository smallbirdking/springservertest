package com.example.demo.mongodb.dao;

import com.example.demo.mongodb.entity.UserProfile;

import java.util.List;

public interface UserProfileDao {

    public void insertOneUserProfile(UserProfile userProfile);

    public void insertUserProfiles(List<UserProfile> userProfiles);
}
