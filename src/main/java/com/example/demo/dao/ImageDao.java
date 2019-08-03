package com.example.demo.dao;

import com.example.demo.entity.Image;

import java.util.List;

public interface ImageDao {

    public Image findOne();

    public void saveImage(Image file);
}
