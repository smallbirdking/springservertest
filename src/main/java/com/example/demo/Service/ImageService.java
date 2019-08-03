package com.example.demo.Service;

import com.example.demo.entity.Image;
import com.example.demo.entity.ImageUpd;

import java.util.List;

public interface ImageService {

    public Image findOne();

    public void save(Image file);
}
