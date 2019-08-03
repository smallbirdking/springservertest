package com.example.demo.dao;

import com.example.demo.entity.Text;
import com.example.demo.entity.User;

import java.util.List;


public interface TextDao {
    public List<Text> findAll();

    public void save(Text text);
}
