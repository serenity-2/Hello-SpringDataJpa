package com.qcq.Hello_SpringDataJpa.domain;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
* 
* @TableName user_order_relation
*/

@Entity(name = "user_order_relation")
public class UserOrderRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id",insertable = false,updatable = false)
    private Integer userId;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserOrderRelation{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                '}';
    }
}
