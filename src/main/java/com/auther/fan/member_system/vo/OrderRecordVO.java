package com.auther.fan.member_system.vo;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 返回到积分记录页面的VO类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRecordVO implements Serializable {

    private Integer sumPrice;
    private String orderId;
    private LocalDateTime placedAt;
    private String paymentMethod;
    private Integer number;
    private String productName;
    private Integer onePrice;
    private String memberName;
    private String memberPhone;
    private String orderSource;
    private String deliveryMethod;
    private Integer shipmentStatus;


}
