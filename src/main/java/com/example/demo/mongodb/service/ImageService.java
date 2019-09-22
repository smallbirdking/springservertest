package com.example.demo.mongodb.service;

import com.example.demo.mongodb.entity.Image;
import com.example.demo.mongodb.entity.ImageListData;

import java.util.List;

public interface ImageService {

    public Image findOne();

    public ImageListData findAll(int id);

    public void save(Image file);

    public void saveMultipImages(List<Image> files);
}
