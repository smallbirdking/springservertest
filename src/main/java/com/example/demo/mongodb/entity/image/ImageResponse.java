package com.example.demo.mongodb.entity.image;

import com.example.demo.entity.BaseResponse;

import java.util.HashMap;
import java.util.Map;

public class ImageResponse extends BaseResponse {
    Map<String, String> urls = new HashMap<>();

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

//    List<String> oldPaths = new ArrayList<>();
//    List<String> newPaths = new ArrayList<>();
//
//    public List<String> getOldPaths() {
//        return oldPaths;
//    }
//
//    public void setOldPaths(List<String> oldPaths) {
//        this.oldPaths = oldPaths;
//    }
//
//    public List<String> getNewPaths() {
//        return newPaths;
//    }
//
//    public void setNewPaths(List<String> newPaths) {
//        this.newPaths = newPaths;
//    }
}
