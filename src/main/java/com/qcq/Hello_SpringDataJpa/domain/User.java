package com.qcq.Hello_SpringDataJpa.domain;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Optional;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Auditable;

/**
* 用户信息表
* @TableName user
*/
@Data
@Accessors(chain = true)
//@Table(name = "user") 可不写，默认类名驼峰匹配
@Entity //作为实体类
 public class User {

    /**
    * 用户ID
     * 在javax.persistence.GenerationType中定义了以下几种可供选择的策略：
     * –IDENTITY：采用数据库ID自增长的方式来自增主键字段，Oracle 不支持这种方式；
     * –AUTO： JPA自动选择合适的策略，是默认选项；
     * –SEQUENCE：通过序列产生主键，通过@SequenceGenerator 注解指定序列名，MySql不支持这种方式
     * –TABLE：通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
