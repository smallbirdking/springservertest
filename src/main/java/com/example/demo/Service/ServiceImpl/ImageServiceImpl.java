package com.example.demo.Service.ServiceImpl;

import com.example.demo.Service.ImageService;
import com.example.demo.dao.ImageDao;
import com.example.demo.entity.Image;
import com.example.demo.entity.ImageData;
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
