package com.example.demo.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Document(collection = "Thread")
@Repository
public class Thread {

    /** ID */
    @Id
    private Long id ;
    /** 创建人 */
    private Long createdUserId ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private Long updatedUserId ;
    /** 更新时间 */
    private Date updatedTime ;
    /** 帖子标题 */
    private String trSubject ;
    /** 帖子内容 */
    private String trBody ;
    /** 地点列表 */
    private List localList ;
    /** 提醒 */
    private List mentionedUserList ;
    /** 管理员列表 */
    private List adminList ;
    /** 话题 */
    private List topicList ;

    /** ID */
    public Long getId(){
        return this.id;
    }
    /** ID */
    public void setId(Long id){
        this.id = id;
    }
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
}
