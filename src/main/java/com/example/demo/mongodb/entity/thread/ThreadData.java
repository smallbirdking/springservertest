package com.example.demo.mongodb.entity.thread;

import java.util.Date;

public class ThreadData {
    String title;
    String content;
    Date createdTime;

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
}
