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
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    private String memberId;

    private Integer preBalance;

    private Integer addMoney;

    private Integer sendMoney;

    private Integer afterBalance;

    private String reason;

    private String note;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(Integer preBalance) {
        this.preBalance = preBalance;
    }

    public Integer getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(Integer addMoney) {
        this.addMoney = addMoney;
    }

    public Integer getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(Integer sendMoney) {
        this.sendMoney = sendMoney;
    }

    public Integer getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Integer afterBalance) {
        this.afterBalance = afterBalance;
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
        return "Record{" +
            "recordId = " + recordId +
            ", memberId = " + memberId +
            ", preBalance = " + preBalance +
            ", addMoney = " + addMoney +
            ", sendMoney = " + sendMoney +
            ", afterBalance = " + afterBalance +
            ", reason = " + reason +
            ", note = " + note +
        "}";
    }
}
