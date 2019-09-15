package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "User_Profile")
@Repository
public class UserProfile implements Serializable,Cloneable{
    /** ID */
    @Id
    @DBRef
    private Long id ;
    /** 姓 */
    @Field("FIRST_NAME")
    private String firstName ;
    /** 名 */
    @Field("LAST_NAME")
    private String lastName ;
    /** 用户昵称 */
    @Field("NICK_NAME")
    private String nickName ;
    /** 密码 */
    @Field("PASSWORD")
    private String password ;
    /** 生日 */
    @Field("BIRTHDAY")
    private Date birthday;
    /** 邮箱 */
    @Field("EMAIL")
    private String email ;
    /** 电话 */
    @Field("TELEPHONE")
    private String telephone ;
    /** 用户等级 */
    @Field("USER_LEVEL")
    private Integer userLevel ;
    /** 性别 */
    @Field("SEX")
    private Integer sex ;

    /** ID */
    public Long getId(){
        return this.id;
    }
    /** ID */
    public void setId(Long id){
        this.id = id;
    }
    /** 姓 */
    public String getFirstName(){
        return this.firstName;
    }
    /** 姓 */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    /** 名 */
    public String getLastName(){
        return this.lastName;
    }
    /** 名 */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    /** 用户昵称 */
    public String getNickName(){
        return this.nickName;
    }
    /** 用户昵称 */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    /** 密码 */
    public String getPassword(){
        return this.password;
    }
    /** 密码 */
    public void setPassword(String password){
        this.password = password;
    }
    /** 生日 */
    public Date getBirthday(){
        return this.birthday;
    }
    /** 生日 */
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    /** 邮箱 */
    public String getEmail(){
        return this.email;
    }
    /** 邮箱 */
    public void setEmail(String email){
        this.email = email;
    }
    /** 电话 */
    public String getTelephone(){
        return this.telephone;
    }
    /** 电话 */
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    /** 用户等级 */
    public Integer getUserLevel(){
        return this.userLevel;
    }
    /** 用户等级 */
    public void setUserLevel(Integer userLevel){
        this.userLevel = userLevel;
    }
    /** 性别 */
    public Integer getSex(){
        return this.sex;
    }
    /** 性别 */
    public void setSex(Integer sex){
        this.sex = sex;
    }
}