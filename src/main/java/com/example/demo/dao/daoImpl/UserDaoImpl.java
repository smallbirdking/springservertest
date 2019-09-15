package com.example.demo.dao.daoImpl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl  implements UserDao {

    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查找全部
     */
    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public List<User> findByUserName(String userName) {
        Criteria criteria = Criteria.where("USER_NAME").in(userName);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public void addUsers(List<User> users) {
        mongoTemplate.insertAll(users);
    }

}
