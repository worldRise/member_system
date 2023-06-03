package com.auther.fan.member_system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 会员查询页面返回数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryMemberVo implements Serializable {

    private String memberName;
    private String memberPhone;
    private String memberLevel;
    private String[] memberTag;
    private Integer memberScore;
    private Integer orderCount;
    private Integer orderMoney;
    private Boolean paid;
    private Integer Balance;

}
