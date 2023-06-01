package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public class Growth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "growth_id", type = IdType.AUTO)
    private Integer growthId;

    private String memberId;

    private Integer preGrowth;

    private Integer growth;

    private Integer afterGrowth;

    private String reason;

    private String note;

    public Integer getGrowthId() {
        return growthId;
    }

    public void setGrowthId(Integer growthId) {
        this.growthId = growthId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getPreGrowth() {
        return preGrowth;
    }

    public void setPreGrowth(Integer preGrowth) {
        this.preGrowth = preGrowth;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getAfterGrowth() {
        return afterGrowth;
    }

    public void setAfterGrowth(Integer afterGrowth) {
        this.afterGrowth = afterGrowth;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Growth{" +
            "growthId = " + growthId +
            ", memberId = " + memberId +
            ", preGrowth = " + preGrowth +
            ", growth = " + growth +
            ", afterGrowth = " + afterGrowth +
            ", reason = " + reason +
            ", note = " + note +
        "}";
    }
}
