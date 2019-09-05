package com.example.demo.dao;

import com.example.demo.entity.Image;
import com.example.demo.entity.ImageData;

import java.util.List;

public interface ImageDao {

    public Image findOne();

    public ImageData findAll();

    public void saveImage(Image file);

    public void saveMultipImages(List<Image> files);
}
