package com.example.demo.mongodb.entity;

import java.util.List;

public class ImageListData {

    private List<ImageUpd> images;

    public ImageListData(List<ImageUpd> images) {
        this.images = images;
    }

    public List<ImageUpd> getImages() {
        return images;
    }

    public void setImages(List<ImageUpd> images) {
        this.images = images;
    }
}
