package com.example.demo.mongodb.dao;

import com.example.demo.mongodb.entity.Text;

import java.util.List;


public interface TextDao {
    public List<Text> findAll();

    public void save(Text text);
}
