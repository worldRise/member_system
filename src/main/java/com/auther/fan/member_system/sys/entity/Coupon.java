package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "coupon_id", type = IdType.AUTO)
    private Integer couponId;

    private String memberId;

    private String couponName;

    private String couponNote;

    private Integer money;

    private String source;

    private String couponType;

    private String useRegion;

    private Boolean couponStatus;

    private LocalDateTime expirationDate;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponNote() {
        return couponNote;
    }

    public void setCouponNote(String couponNote) {
        this.couponNote = couponNote;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getUseRegion() {
        return useRegion;
    }

    public void setUseRegion(String useRegion) {
        this.useRegion = useRegion;
    }

    public Boolean getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Boolean couponStatus) {
        this.couponStatus = couponStatus;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Coupon{" +
            "couponId = " + couponId +
            ", memberId = " + memberId +
            ", couponName = " + couponName +
            ", couponNote = " + couponNote +
            ", money = " + money +
            ", source = " + source +
            ", couponType = " + couponType +
            ", useRegion = " + useRegion +
            ", couponStatus = " + couponStatus +
            ", expirationDate = " + expirationDate +
        "}";
    }
}
