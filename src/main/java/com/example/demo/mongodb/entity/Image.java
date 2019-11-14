package com.example.demo.mongodb.entity;


import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

@Document(collection = "Image")
@Repository
public class Image {

  @Field("MD5ID")
  String MD5Id;

  @Field("URL")
  String url;

  @Field("DATA")
  private Binary content; // 文件内容

  public Binary getContent() {
    return content;
  }

  public void setContent(Binary content) {
    this.content = content;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMD5Id() {
    return MD5Id;
  }

  public void setMD5Id(String MD5Id) {
    this.MD5Id = MD5Id;
  }
}
