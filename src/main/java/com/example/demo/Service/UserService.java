package com.example.demo.Service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    /*User getUser(Integer id);

    void update(User user);

    void insert(User user);

    void insertAll(List<User> users);

    void remove(Integer id);

    List<User> findByPage(User user,Pageable pageable);*/
}
