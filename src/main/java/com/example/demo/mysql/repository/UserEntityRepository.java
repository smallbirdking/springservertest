package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity,Integer> {
    @Query(value = "select u from UserEntity u where u.userName like %?1")
    List<UserEntity> findByUserName(String userName);

    @Query(value = "select u from UserEntity u where u.id = ?1")
    Optional<UserEntity> findById(Long id);
}