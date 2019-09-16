package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileEntityRepository extends CrudRepository<UserProfileEntity, Long> {

//    @Query("select u from User_Profile where u.USER_ID = ?1")
//    List<UserProfileEntity> findByUserID(Long id);
}