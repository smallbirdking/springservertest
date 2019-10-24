package com.example.demo.mongodb.dao;

import com.example.demo.mongodb.entity.thread.Thread;

import java.util.List;

public interface ThreadDao {

    void save(Thread thread);

    List<Thread> findByUserId(Long id);
}
