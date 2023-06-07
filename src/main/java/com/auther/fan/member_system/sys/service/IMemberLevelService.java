package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.MemberLevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public interface IMemberLevelService extends IService<MemberLevel> {

    List<MemberLevel> getOrderListByMemberId(String levelName);

    boolean saveMemberLevel(MemberLevel memberLevel);

    boolean updateMemberLevel(MemberLevel memberLevel);

    boolean deleteMemberLevelById(Integer levelId);
}
