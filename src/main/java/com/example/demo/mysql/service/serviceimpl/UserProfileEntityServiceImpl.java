package com.example.demo.mysql.service.serviceimpl;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.repository.UserEntityRepository;
import com.example.demo.mysql.repository.UserProfileEntityRepository;
import com.example.demo.mysql.service.UserProfileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service("userProfileEntityService")
public class UserProfileEntityServiceImpl implements UserProfileEntityService {
    @Autowired
    private UserProfileEntityRepository userProfileEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public List<UserProfileEntity> findByUserEntity(UserEntity userEntity) {
        return userProfileEntityRepository.findByUserID(userEntity);
    }

    @Override
    @Transactional
    public Optional<UserProfileEntity> insertUserProfile(UserProfileEntity userProfileEntity) {
        UserProfileEntity userProfile = userProfileEntityRepository.save(userProfileEntity);
        return Optional.of(userProfile);
    }

    @Override
    @Transactional
    public Stream<UserProfileEntity> findByUserID(Long userId) {
        List<UserProfileEntity> userProfiles = userProfileEntityRepository.findByUserID(userId);
        return userProfiles.stream();
    }

    @Override
    public Page<UserProfileEntity> findByFirstName(String firstName, Pageable sort) {
        Page<UserProfileEntity> userProfiles = userProfileEntityRepository.findByFirstName(firstName, sort);
        return userProfiles;
    }
}
