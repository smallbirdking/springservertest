package com.example.demo.mongodb.service;

import com.example.demo.mongodb.entity.Text;
import com.example.demo.mongodb.entity.TextData;

public interface TextService {
    TextData findAll();

    void save(Text text);
}
