package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface UserProfileEntityRepository extends CrudRepository<UserProfileEntity, Long> {

    @Query("select u from UserProfileEntity u where u.userByUserId = ?1")
    List<UserProfileEntity> findByUserID(UserEntity userEntity);

    @Query(value = "select u from User_Profile u where u.USER_ID = ?1", nativeQuery = true)
    Stream<UserProfileEntity> findByUserID(long id);

    @Query(value = "select u from #{#entityName} u where u.firstName = :firstname",
            countQuery = "select count(u) from #{#entityName} u where u.firstName = :firstname")
    @Transactional(timeout = 10)
    Page<UserProfileEntity> findByFirstName(@Param("firstname") String firstName, Pageable sort);

//    @Async
//    ListenableFuture<UserEntity> findOneByLastname(String lastname);
}