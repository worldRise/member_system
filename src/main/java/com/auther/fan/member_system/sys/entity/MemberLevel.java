package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("member_level")
public class MemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "level_id", type = IdType.AUTO)
    private Integer levelId;

    private String levelName;

    private Integer conditionGrowth;

    private Boolean status;

    private LocalDateTime lastUpdatedTime;

    private Integer couponId;

    private String membershipName;

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getConditionGrowth() {
        return conditionGrowth;
    }

    public void setConditionGrowth(Integer conditionGrowth) {
        this.conditionGrowth = conditionGrowth;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    @Override
    public String toString() {
        return "MemberLevel{" +
            "levelId = " + levelId +
            ", levelName = " + levelName +
            ", conditionGrowth = " + conditionGrowth +
            ", status = " + status +
            ", lastUpdatedTime = " + lastUpdatedTime +
            ", couponId = " + couponId +
            ", membershipName = " + membershipName +
        "}";
    }
}
