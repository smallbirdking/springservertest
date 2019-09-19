package com.example.demo.mongodb.service;

import com.example.demo.mongodb.entity.Thread;

import java.util.List;

public interface ThreadService {

    void insertThread(Thread thread);

    List<Thread> findByUserId(Long userId);

}
