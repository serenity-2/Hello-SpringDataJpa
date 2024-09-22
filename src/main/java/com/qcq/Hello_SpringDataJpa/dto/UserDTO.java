package com.qcq.Hello_SpringDataJpa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 用户账号
     */
    @Column(name = "user_name") // 可不写，默认列明驼峰匹配
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;

    private String email;
    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 创建时间
     */
    private Date createTime;
}
