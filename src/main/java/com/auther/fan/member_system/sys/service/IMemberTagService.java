package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.MemberTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public interface IMemberTagService extends IService<MemberTag> {

    List<Map<Object,Object>> getOrderListByMemberId(String tagType, String tagName);

    boolean saveMemberTag(MemberTag memberTag);

    boolean updateMemberTag(MemberTag memberTag);

    boolean deleteMemberTag(Integer tagId);
}
