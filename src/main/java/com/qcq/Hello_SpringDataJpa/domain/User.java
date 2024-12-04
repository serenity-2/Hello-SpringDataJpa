package com.qcq.Hello_SpringDataJpa.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

/**
* 用户信息表
* @TableName user
*/
//@Table(name = "user") 可不写，默认类名驼峰匹配
@NoArgsConstructor
@Accessors(chain = true)
@Entity //作为实体类
 public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;
    /**
    * 用户账号
    */
    @Column(name = "user_name") // 可不写，默认列明驼峰匹配
    private String userName;
    /**
    * 用户昵称
    */
    @Column(name = "nick_name")
    private String nickName;
    /**
    * 用户邮箱
    */
    @Column(name = "email")
    private String email;
    /**
    * 手机号码
    */
    @Column(name = "phone_number")
    private String phoneNumber;
    /**
    * 用户性别（0男 1女 2未知）
    */
    @Column(name = "sex")
    private String sex;
    /**
    * 帐号状态（1正常 0停用）
    */
    @Column(name = "status")
    private String status = "1";
    /**
    * 创建者
    */
    @Column(name = "create_by")
    private String createBy;
    /**
    * 创建时间
     * updatable = false: 表示该字段在更新时不会被更新
    */
    @Column(name = "create_time",updatable = false)
    private LocalDateTime createTime;
    /**
    * 更新者
    */
    @Column(name = "update_by")
    private String updateBy;
    /**
    * 更新时间
    */
    @Column(name = "update_time")
    private LocalDateTime updateTime;


   @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
   private List<UserOrderRelation> userOrderRelationList;

   //get set ......


    /**
     * 保存前设置创建时间，更新时间
     */
    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

    /**
     * 更新前设置更新时间
     */
    @PreUpdate
    protected void onUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public List<UserOrderRelation> getUserOrderRelationList() {
        return userOrderRelationList;
    }

    public void setUserOrderRelationList(List<UserOrderRelation> userOrderRelationList) {
        this.userOrderRelationList = userOrderRelationList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", userOrderRelationList=" + userOrderRelationList +
                '}';
    }
}
