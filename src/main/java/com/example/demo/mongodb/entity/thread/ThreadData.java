package com.example.demo.mongodb.entity.thread;

import java.util.Date;
import java.util.List;

public class ThreadData {
    String title;
    String content;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    Date createdTime;
    List<String> imgUris;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
      return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
      this.createdTime = createdTime;
    }

    public List<String> getImgUris() {
        return imgUris;
    }

    public void setImgUris(List<String> imgUris) {
        this.imgUris = imgUris;
    }
}
