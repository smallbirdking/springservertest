package com.example.demo.mongodb.entity;


import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Document(collection = "Image")
@Repository
public class Image {

    private Binary content; // 文件内容

    public Binary getContent() {
        return content;
    }

    public void setContent(Binary content) {
        this.content = content;
    }
}
