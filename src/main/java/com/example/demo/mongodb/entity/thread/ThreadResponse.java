package com.example.demo.mongodb.entity.thread;

import com.example.demo.entity.BaseResponse;

public class ThreadResponse extends BaseResponse {
//    String thread;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
