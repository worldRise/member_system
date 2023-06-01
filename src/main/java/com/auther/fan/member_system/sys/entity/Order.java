package com.auther.fan.member_system.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    private String memberId;

    private Integer productId;

    private LocalDateTime placedAt;

    private LocalDateTime paidAt;

    private String paymentMethod;

    private String orderType;

    private String orderSource;

    private String orderNote;

    private Integer number;

    private Boolean deleted;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId = " + orderId +
            ", memberId = " + memberId +
            ", productId = " + productId +
            ", placedAt = " + placedAt +
            ", paidAt = " + paidAt +
            ", paymentMethod = " + paymentMethod +
            ", orderType = " + orderType +
            ", orderSource = " + orderSource +
            ", orderNote = " + orderNote +
            ", number = " + number +
            ", deleted = " + deleted +
        "}";
    }
}
