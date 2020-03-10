package com.example.demo.mysql.entity.comment;

import com.example.demo.entity.BaseResponse;

import java.util.List;

public class CommentResponse extends BaseResponse {
  private int totalAmount;
  private List<CommentDetail> commentList;

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public List<CommentDetail> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<CommentDetail> commentList) {
    this.commentList = commentList;
  }
}
