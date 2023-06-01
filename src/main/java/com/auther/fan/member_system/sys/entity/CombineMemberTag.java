package com.auther.fan.member_system.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@TableName("combine_member_tag")
public class CombineMemberTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "combine_memeber_tag_id", type = IdType.AUTO)
    private Integer combineMemeberTagId;

    private String memberId;

    private Integer tagId;

    public Integer getCombineMemeberTagId() {
        return combineMemeberTagId;
    }

    public void setCombineMemeberTagId(Integer combineMemeberTagId) {
        this.combineMemeberTagId = combineMemeberTagId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "CombineMemberTag{" +
            "combineMemeberTagId = " + combineMemeberTagId +
            ", memberId = " + memberId +
            ", tagId = " + tagId +
        "}";
    }
}
