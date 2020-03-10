package com.example.demo.mysql.entity.comment;

import java.sql.Timestamp;

public class BaseComment {
  private long id;
  private long userId;
  private String nickName;
  private String userLogo;
  private String threadId;
  private String content;
  private Timestamp createDate;
  private int status;
  private int agreement;

  public BaseComment(long id, long userId, String nickName, String userLogo, String threadId, String content,
      Timestamp createDate, int status, int agreement) {
    this.id = id;
    this.userId = userId;
    this.nickName = nickName;
    this.userLogo = userLogo;
    this.threadId = threadId;
    this.content = content;
    this.createDate = createDate;
    this.status = status;
    this.agreement = agreement;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getUserLogo() {
    return userLogo;
  }

  public void setUserLogo(String userLogo) {
    this.userLogo = userLogo;
  }

  public String getThreadId() {
    return threadId;
  }

  public void setThreadId(String threadId) {
    this.threadId = threadId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getAgreement() {
    return agreement;
  }

  public void setAgreement(int agreement) {
    this.agreement = agreement;
  }
}
