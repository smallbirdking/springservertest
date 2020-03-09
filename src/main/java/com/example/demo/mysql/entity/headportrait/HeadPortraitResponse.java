package com.example.demo.mysql.entity.headportrait;

import com.example.demo.entity.BaseResponse;

import java.util.HashMap;
import java.util.Map;

public class HeadPortraitResponse extends BaseResponse {

    Map<Long, String> urls = new HashMap<>();

    public Map<Long, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<Long, String> urls) {
        this.urls = urls;
    }
}
