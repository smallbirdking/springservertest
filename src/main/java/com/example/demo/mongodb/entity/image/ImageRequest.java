package com.example.demo.mongodb.entity.image;

import java.util.ArrayList;
import java.util.List;

public class ImageRequest {

    private List<ImageInfo> imageInfos = new ArrayList<>();

//    private MultipartFile multipartBody;

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

//    public MultipartFile getMultipartBody() {
//        return multipartBody;
//    }
//
//    public void setMultipartBody(MultipartFile multipartBody) {
//        this.multipartBody = multipartBody;
//    }

//    public List<MultipartFile> getMultipartBody() {
//        return multipartBody;
//    }
//
//    public void setMultipartBody(List<MultipartFile> multipartBody) {
//        this.multipartBody = multipartBody;
//    }
}
