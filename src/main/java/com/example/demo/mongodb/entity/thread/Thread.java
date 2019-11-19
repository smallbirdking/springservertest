package com.example.demo.mongodb.entity.thread;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Document(collection = "Thread")
@Repository
public class Thread {

    /** 创建人 */
    @Field("CREATED_USER_ID")
    private Long createdUserId ;
    /** 创建时间 */
    @Field("CREATED_TIME")
    @CreatedBy
    private Date createdTime ;
    /** 更新人 */
    @Field("UPDATED_USER_ID")
    private Long updatedUserId ;
    /** 更新时间 */
    @Field("UPDATED_TIME")
    private Date updatedTime ;
    /** 帖子标题 */
    @Field("TR_SUBJECT")
    private String trSubject ;
    /** 帖子内容 */
    @Field("TR_BODY")
    private String trBody ;
    /** 地点列表 */
    @Field("LOCAL_LIST")
    private List localList ;
    /** 提醒 */
    @Field("MENTIONED_USER_LIST")
    private List mentionedUserList ;
    /** 管理员列表 */
    @Field("ADMIN_LIST")
    private List adminList ;
    /** 话题 */
    @Field("TOPIC_LIST")
    private List topicList ;

    /** 话题 */
    @Field("IMAGE_LIST")
    private List imageList ;

    /** 创建人 */
    public Long getCreatedUserId(){
        return this.createdUserId;
    }
    /** 创建人 */
    public void setCreatedUserId(Long createdUserId){
        this.createdUserId = createdUserId;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public Long getUpdatedUserId(){
        return this.updatedUserId;
    }
    /** 更新人 */
    public void setUpdatedUserId(Long updatedUserId){
        this.updatedUserId = updatedUserId;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
    /** 帖子标题 */
    public String getTrSubject(){
        return this.trSubject;
    }
    /** 帖子标题 */
    public void setTrSubject(String trSubject){
        this.trSubject = trSubject;
    }
    /** 帖子内容 */
    public String getTrBody(){
        return this.trBody;
    }
    /** 帖子内容 */
    public void setTrBody(String trBody){
        this.trBody = trBody;
    }
    /** 地点列表 */
    public List getLocalList(){
        return this.localList;
    }
    /** 地点列表 */
    public void setLocalList(List localList){
        this.localList = localList;
    }
    /** 提醒 */
    public List getMentionedUserList(){
        return this.mentionedUserList;
    }
    /** 提醒 */
    public void setMentionedUserList(List mentionedUserList){
        this.mentionedUserList = mentionedUserList;
    }
    /** 管理员列表 */
    public List getAdminList(){
        return this.adminList;
    }
    /** 管理员列表 */
    public void setAdminList(List adminList){
        this.adminList = adminList;
    }
    /** 话题 */
    public List getTopicList(){
        return this.topicList;
    }
    /** 话题 */
    public void setTopicList(List topicList){
        this.topicList = topicList;
    }

    /** 图片列表 */
    public List getImageList() {
      return imageList;
    }

    /** 图片列表 */
    public void setImageList(List imageList) {
      this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "Thread{" +
                "createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                ", trSubject='" + trSubject + '\'' +
                ", trBody='" + trBody + '\'' +
                ", localList=" + localList +
                ", mentionedUserList=" + mentionedUserList +
                ", adminList=" + adminList +
                ", topicList=" + topicList +
                '}';
    }
}
