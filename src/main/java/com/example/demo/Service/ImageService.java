package com.example.demo.Service;

import com.example.demo.entity.Image;
import com.example.demo.entity.ImageData;
import java.util.List;

public interface ImageService {

    public Image findOne();

    public ImageData findAll(int id);

    public void save(Image file);

    public void saveMultipImages(List<Image> files);
}
