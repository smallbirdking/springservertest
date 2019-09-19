package com.example.demo.mongodb.service.serviceimpl;

import com.example.demo.mongodb.dao.ThreadDao;
import com.example.demo.mongodb.entity.Thread;
import com.example.demo.mongodb.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("threadService")
public class ThreadServiceImpl implements ThreadService {
    @Autowired
    private ThreadDao threadDao;

    @Override
    public void insertThread(Thread thread) {

    }

    @Override
    public List<Thread> findByUserId(Long userId) {
        return null;
    }
}
