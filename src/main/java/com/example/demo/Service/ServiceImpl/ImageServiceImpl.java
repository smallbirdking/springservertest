package com.example.demo.Service.ServiceImpl;

import com.example.demo.Service.ImageService;
import com.example.demo.dao.ImageDao;
import com.example.demo.entity.Image;
import com.example.demo.entity.ImageUpd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public Image findOne() {
        Image one = imageDao.findOne();

//        ImageUpd imageUpd = new ImageUpd();
//        imageUpd.setContent(one.getContent().getData());
        return one;
    }

    @Override
    public void save(Image file) {
        imageDao.saveImage(file);
    }
}
