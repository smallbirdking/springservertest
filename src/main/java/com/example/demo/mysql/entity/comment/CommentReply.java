package com.example.demo.mysql.entity.comment;

public class CommentReply extends BaseComment {

  private long toReplyUserId;
  private String toReplyUserName;
  private long lastCommentId;

  public CommentReply(CommentEntity comment, String nickName, String userLogo) {
    super(comment.getId(), comment.getUserId(), nickName, userLogo, comment.getThreadId(), comment.getContent(),
        comment.getCreatedTime(), comment.getStatus(), comment.getAgreement());
    lastCommentId = comment.getLastCommentId();
    toReplyUserId = comment.getToReplyUserId();
  }

  public long getToReplyUserId() {
    return toReplyUserId;
  }

  public void setToReplyUserId(long toReplyUserId) {
    this.toReplyUserId = toReplyUserId;
  }

  public String getToReplyUserName() {
    return toReplyUserName;
  }

  public void setToReplyUserName(String toReplyUserName) {
    this.toReplyUserName = toReplyUserName;
  }

  public long getLastCommentId() {
    return lastCommentId;
  }

  public void setLastCommentId(long lastCommentId) {
    this.lastCommentId = lastCommentId;
  }
}
