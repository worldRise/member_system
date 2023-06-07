package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2023-06-07
 */
@TableName("member_ship")
public class MemberShip implements Serializable {

    private static final long serialVersionUID = 1L;

    private String membershipName;

    private String membershipType;

    private String membershipNote;

    private Boolean membershipStatus;

    private LocalDateTime lastUpdatedTime;

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipNote() {
        return membershipNote;
    }

    public void setMembershipNote(String membershipNote) {
        this.membershipNote = membershipNote;
    }

    public Boolean getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(Boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public String toString() {
        return "MemberShip{" +
            "membershipName = " + membershipName +
            ", membershipType = " + membershipType +
            ", membershipNote = " + membershipNote +
            ", membershipStatus = " + membershipStatus +
            ", lastUpdatedTime = " + lastUpdatedTime +
        "}";
    }
}
