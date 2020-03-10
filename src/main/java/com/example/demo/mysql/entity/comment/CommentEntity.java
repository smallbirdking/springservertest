package com.example.demo.mysql.entity.comment;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Comment", schema = "HeatWave", catalog = "")
public class CommentEntity {
    private long id;
    private String threadId;
    private String content;
    private long userId;
    private Timestamp createdTime;
    private Long toReplyUserId;
    private Long lastCommentId;
    private int status;
    private int agreement;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "THREAD_ID")
    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "CREATED_TIME")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "TO_REPLY_USER_ID")
    public Long getToReplyUserId() {
        return toReplyUserId;
    }

    public void setToReplyUserId(Long toReplyUserId) {
        this.toReplyUserId = toReplyUserId;
    }

    @Basic
    @Column(name = "LAST_COMMENT_ID")
    public Long getLastCommentId() {
        return lastCommentId;
    }

    public void setLastCommentId(Long lastCommentId) {
        this.lastCommentId = lastCommentId;
    }

    @Basic
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "AGREEMENT")
    public int getAgreement() {
        return agreement;
    }

    public void setAgreement(int agreement) {
        this.agreement = agreement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (agreement != that.agreement) return false;
        if (threadId != null ? !threadId.equals(that.threadId) : that.threadId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (userId != that.userId) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;
        if (toReplyUserId != null ? !toReplyUserId.equals(that.toReplyUserId) : that.toReplyUserId != null)
            return false;
        if (lastCommentId != null ? !lastCommentId.equals(that.lastCommentId) : that.lastCommentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (threadId != null ? threadId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (toReplyUserId != null ? toReplyUserId.hashCode() : 0);
        result = 31 * result + (lastCommentId != null ? lastCommentId.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + agreement;
        return result;
    }
}
