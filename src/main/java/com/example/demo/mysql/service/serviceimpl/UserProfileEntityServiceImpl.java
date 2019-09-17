package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.repository.UserEntityRepository;
import com.example.demo.mysql.repository.UserProfileEntityRepository;
import com.example.demo.mysql.service.UserProfileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("userProfileEntityService")
public class UserProfileEntityServiceImpl implements UserProfileEntityService {
    @Autowired
    private UserProfileEntityRepository userProfileEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public List<UserProfileEntity> findByUserID(Long id) {
        Optional<UserEntity> userEntity = userEntityRepository.findById(id);
        if (userEntity.isPresent()){
            return userProfileEntityRepository.findByUserID(userEntity.get());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<UserProfileEntity> insertUserProfile(UserProfileEntity userProfileEntity) {
        UserProfileEntity userProfile = userProfileEntityRepository.save(userProfileEntity);
        return Optional.of(userProfile);
    }
}
