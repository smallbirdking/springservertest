package com.example.demo.mongodb.dao.daoImpl;

import com.example.demo.mongodb.dao.TextDao;
import com.example.demo.mongodb.entity.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("textDao")
public class TextDaoImpl implements TextDao {

    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查找全部
     */
    @Override
    public List<Text> findAll() {
        return mongoTemplate.findAll(Text.class);
    }

    @Override
    public void save(Text text) {
        mongoTemplate.save(text);
    }

}
