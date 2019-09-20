package com.example.demo.mongodb.dao.daoImpl;

import com.example.demo.mongodb.dao.ThreadDao;
import com.example.demo.mongodb.entity.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("threadDao")
public class ThreadDaoImpl implements ThreadDao {

    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Thread thread) {
        mongoTemplate.save(thread);
    }

    @Override
    public List<Thread> findByUserId(Long id) {
        Query query = new Query(Criteria.where("CREATED_USER_ID").is(id));
        return mongoTemplate.find(query, Thread.class, "Thread");
    }
}
