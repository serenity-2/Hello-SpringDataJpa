package com.qcq.Hello_SpringDataJpa.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private String sex;

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


    @ManyToMany
    @JoinTable(
            name = "StudentCourseRelation", // 中间表的名称
            joinColumns = @JoinColumn(name = "studentId"), // Student 表在中间表中的外键列
            inverseJoinColumns = @JoinColumn(name = "courseId")) // Course 表在中间表中的外键列
    private List<StudentCourseRelation> studentCourseRelationList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public List<StudentCourseRelation> getStudentCourseRelationList() {
        return studentCourseRelationList;
    }

    public void setStudentCourseRelationList(List<StudentCourseRelation> studentCourseRelationList) {
        this.studentCourseRelationList = studentCourseRelationList;
    }
}
