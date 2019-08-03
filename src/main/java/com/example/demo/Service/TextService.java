package com.example.demo.Service;

import com.example.demo.entity.Text;
import com.example.demo.entity.TextData;
import com.example.demo.entity.User;

import java.util.List;

public interface TextService {
    TextData findAll();

    void save(Text text);
}
