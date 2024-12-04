package com.qcq.Hello_SpringDataJpa.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Integer orderId;

    private String orderNumber;

    private Integer productId;

    private String productName;

    private BigDecimal productPrice;

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

}
