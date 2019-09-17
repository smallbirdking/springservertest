package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileEntityRepository extends CrudRepository<UserProfileEntity, Long> {

    @Query("select u from UserProfileEntity u where u.userByUserId = ?1")
    List<UserProfileEntity> findByUserID(UserEntity id);
}