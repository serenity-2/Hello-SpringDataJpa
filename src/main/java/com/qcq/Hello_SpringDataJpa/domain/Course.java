package com.qcq.Hello_SpringDataJpa.domain;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class Course {
    private Integer id;

    private String courseNo;

    private String courseName;

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
}
