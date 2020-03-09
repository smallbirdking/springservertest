package com.example.demo.mysql.service;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserProfileEntityService {

    List<UserProfileEntity> findByUserEntity(UserEntity userEntity);

    Optional<UserProfileEntity> insertUserProfile(UserProfileEntity userProfileEntity);

    Stream<UserProfileEntity> findByUserID(Long userId);

    Page<UserProfileEntity> findByFirstName(@Param("firstname") String firstName, Pageable sort);

    Optional<UserProfileEntity> updateHeadPortrait(Long userId, String portraitUrl);
}
