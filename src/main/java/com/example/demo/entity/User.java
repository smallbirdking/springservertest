package com.example.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "User")
@CompoundIndexes({
        @CompoundIndex(name = "userName_idx", def = "{'USER_NAME':1}")
})
@Repository
public class User implements Serializable,Cloneable{
    /** ID */
    @Id
    @DBRef
    private Long id ;
    /** 用户名 */
    @Field("USER_NAME")
    private String userName ;
    /** 用户密码 */
    @Field("USER_PASSWORD")
    private String userPassword ;
    /** 创建方式 */
    @Field("CREATE_BY")
    private String createdBy ;
    /** 创建时间 */
    @Field("CREATE_TIME")
    private Date createdTime ;
    /** 更新时间 */
    @Field("UPDATE_TIME")
    private Date updatedTime ;

    /** ID */
    public Long getId(){
        return this.id;
    }
    /** ID */
    public void setId(Long id){
        this.id = id;
    }
    /** 用户名 */
    public String getUserName(){
        return this.userName;
    }
    /** 用户名 */
    public void setUserName(String userName){
        this.userName = userName;
    }
    /** 用户密码 */
    public String getUserPassword(){
        return this.userPassword;
    }
    /** 用户密码 */
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
    /** 创建方式 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建方式 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }

}
