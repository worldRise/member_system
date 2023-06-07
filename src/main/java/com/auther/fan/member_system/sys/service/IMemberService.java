package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.*;
import com.auther.fan.member_system.vo.QueryMemberVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public interface IMemberService extends IService<Member> {

    List<QueryMemberVo> listQueryMember(Integer branch,Integer[] orderNum,String creatTime);

    boolean updateScore(Score score);

    boolean updateRecord(Record record);

    boolean updateMemberTag(List<CombineMemberTag> combineMemberTags);

    boolean updateMember(Member member);

    boolean updateMemberGrowth(Growth growth);

    boolean removeLogic(String memberId);
}
