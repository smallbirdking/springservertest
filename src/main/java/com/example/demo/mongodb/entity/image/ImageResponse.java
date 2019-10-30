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
}
