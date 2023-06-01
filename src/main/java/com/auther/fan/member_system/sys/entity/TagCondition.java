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
@TableName("tag_condition")
public class TagCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "condition_id", type = IdType.AUTO)
    private Integer conditionId;

    private LocalDateTime lastConsumptionTime;

    private Integer lastConsumptionCount;

    private Integer totalAmount;

    private Integer orderAmount;

    private Integer totalPoints;

    private Integer rechargeCount;

    private Integer totalRecharges;

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public LocalDateTime getLastConsumptionTime() {
        return lastConsumptionTime;
    }

    public void setLastConsumptionTime(LocalDateTime lastConsumptionTime) {
        this.lastConsumptionTime = lastConsumptionTime;
    }

    public Integer getLastConsumptionCount() {
        return lastConsumptionCount;
    }

    public void setLastConsumptionCount(Integer lastConsumptionCount) {
        this.lastConsumptionCount = lastConsumptionCount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(Integer rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public Integer getTotalRecharges() {
        return totalRecharges;
    }

    public void setTotalRecharges(Integer totalRecharges) {
        this.totalRecharges = totalRecharges;
    }

    @Override
    public String toString() {
        return "TagCondition{" +
            "conditionId = " + conditionId +
            ", lastConsumptionTime = " + lastConsumptionTime +
            ", lastConsumptionCount = " + lastConsumptionCount +
            ", totalAmount = " + totalAmount +
            ", orderAmount = " + orderAmount +
            ", totalPoints = " + totalPoints +
            ", rechargeCount = " + rechargeCount +
            ", totalRecharges = " + totalRecharges +
        "}";
    }
}
