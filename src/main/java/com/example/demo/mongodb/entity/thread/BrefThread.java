package com.example.demo.mongodb.entity.thread;

import java.util.Date;
import java.util.List;

public class BrefThread {
    private String threadId ;
    private Long createdUserId ;
    private Date createdTime ;
    private String trSubject ;
    private List imageList ;
    private int heat;
    private String createdUserName ;

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getTrSubject() {
        return trSubject;
    }

    public void setTrSubject(String trSubject) {
        this.trSubject = trSubject;
    }

    public List getImageList() {
        return imageList;
    }

    public void setImageList(List imageList) {
        this.imageList = imageList;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }
}
