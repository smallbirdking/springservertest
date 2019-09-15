package com.example.demo.dao.daoImpl;

import com.example.demo.dao.UserProfileDao;
import com.example.demo.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl implements UserProfileDao {
    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertOneUserProfile(UserProfile userProfile) {
        mongoTemplate.insert(userProfile);
    }

    @Override
    public void insertUserProfiles(List<UserProfile> userProfiles) {
        mongoTemplate.insertAll(userProfiles);
    }
}
