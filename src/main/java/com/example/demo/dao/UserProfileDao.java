package com.example.demo.dao;

import com.example.demo.entity.UserProfile;

import java.util.List;

public interface UserProfileDao {

    public void insertOneUserProfile(UserProfile userProfile);

    public void insertUserProfiles(List<UserProfile> userProfiles);
}
