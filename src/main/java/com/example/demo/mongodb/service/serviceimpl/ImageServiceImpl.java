package com.example.demo.mongodb.service.serviceimpl;

import com.example.demo.mongodb.service.ImageService;
import com.example.demo.mongodb.dao.ImageDao;
import com.example.demo.mongodb.entity.Image;
import com.example.demo.mongodb.entity.ImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public Image findOne() {
        return imageDao.findOne();
    }

    @Override
    public ImageData findAll(int id){
        ImageData all = imageDao.findAll();
        return all;
    }

    @Override
    public void save(Image file) {
        imageDao.saveImage(file);
    }

    @Override
    public void saveMultipImages(List<Image> files) {
        imageDao.saveMultipImages(files);
    }
}
