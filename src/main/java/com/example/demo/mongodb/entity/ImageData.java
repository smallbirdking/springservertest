package com.example.demo.mongodb.entity;

import java.util.List;

public class ImageData {

    private List<ImageUpd> images;

    public ImageData(List<ImageUpd> images) {
        this.images = images;
    }

    public List<ImageUpd> getImages() {
        return images;
    }

    public void setImages(List<ImageUpd> images) {
        this.images = images;
    }
}
