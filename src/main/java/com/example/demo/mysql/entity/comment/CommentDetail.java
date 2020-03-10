package com.example.demo.mysql.entity.comment;

import java.util.List;

public class CommentDetail extends BaseComment {
  private int replyTotalAmount;
  private List<CommentReply> replyList;

  public CommentDetail(CommentEntity comment, String nickName, String userLogo) {
    super(comment.getId(), comment.getUserId(), nickName, userLogo, comment.getThreadId(), comment.getContent(),
        comment.getCreatedTime(), comment.getStatus(), comment.getAgreement());
  }

  public int getReplyTotalAmount() {
    return replyTotalAmount;
  }

  public void setReplyTotalAmount(int replyTotalAmount) {
    this.replyTotalAmount = replyTotalAmount;
  }

  public List<CommentReply> getReplyList() {
    return replyList;
  }

  public void setReplyList(List<CommentReply> replyList) {
    this.replyList = replyList;
  }
}
