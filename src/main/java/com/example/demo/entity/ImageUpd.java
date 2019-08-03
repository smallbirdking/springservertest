package com.example.demo.entity;

import org.bson.types.Binary;

public class ImageUpd {

    private byte[] content; // 文件内容

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
