package com.example.demo.mongodb.dao;

import com.example.demo.mongodb.entity.Image;
import com.example.demo.mongodb.entity.ImageListData;

import java.util.List;

public interface ImageDao {

    public Image findOne();

    public ImageListData findAll();

    public void saveImage(Image file);

    public void saveMultipImages(List<Image> files);
}
