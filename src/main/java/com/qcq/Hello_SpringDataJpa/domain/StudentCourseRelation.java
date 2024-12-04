package com.qcq.Hello_SpringDataJpa.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class StudentCourseRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String studentId;

    private String courseId;

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

    @ManyToMany(mappedBy = "studentCourseRelationList")
    private List<Student> studentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
