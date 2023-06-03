package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.*;
import com.auther.fan.member_system.sys.mapper.MemberMapper;
import com.auther.fan.member_system.sys.service.IMemberService;
import com.auther.fan.member_system.vo.QueryMemberVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Resource
    private ScoreServiceImpl scoreService;
    @Resource
    private MemberLevelServiceImpl memberLevelService;
    @Resource
    private MemberTagServiceImpl memberTagService;
    @Resource
    private CombineMemberTagServiceImpl combineMemberTagService;
    @Resource
    private OrderServiceImpl orderService;

    /**
     *获取QueryMemberVo的值，并进行返回
     * @return
     */
    @Override
    public List<QueryMemberVo> listQueryMember(Integer branch, Integer[] orderNum, String creatTime) {
        List<QueryMemberVo> queryMemberVos = Lists.newArrayList();

        LambdaQueryWrapper<Member> memberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (branch != null) {
            memberLambdaQueryWrapper.eq(Member::getBranch, branch);
        }
        if (orderNum != null) {
            memberLambdaQueryWrapper.between(Member::getOrderNum,orderNum[0],orderNum[1]);
        }
        if (creatTime != null) {
            //把字符串转换成日期格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime time = LocalDateTime.parse(creatTime,formatter);
            memberLambdaQueryWrapper.eq(Member::getCreateTime, time);
        }
        List<Member> memberList = this.list(memberLambdaQueryWrapper);
        memberList.forEach( member -> {
            QueryMemberVo queryMemberVo = queryMemberVoContent(member);
            queryMemberVos.add(queryMemberVo);
        });
        return queryMemberVos ;
    }

    @Override
    public boolean updateScore(String memberId) {

        return false;
    }


    /**
     * 从member提取需要的值到QueryMemberVo
     * @param member
     * @return
     */
    private QueryMemberVo queryMemberVoContent(Member member){

        QueryMemberVo queryMemberVo = new QueryMemberVo();

        queryMemberVo.setMemberName(member.getName());
        queryMemberVo.setMemberPhone(member.getPhone());
        queryMemberVo.setPaid(member.getPaid());
        queryMemberVo.setBalance(member.getBalance());
        queryMemberVo.setMemberScore(member.getScore());
        queryMemberVo.setMemberLevel(getMemberLevel(member.getMemberGrowth()));
        queryMemberVo.setMemberTag(getMemberTag(member.getMemberId()));
        queryMemberVo.setOrderCount(getOrderAndOrderMoney(member.getMemberId(),0));
        queryMemberVo.setOrderMoney(getOrderAndOrderMoney(member.getMemberId(),1));

        return queryMemberVo;
    }

    /**
     * 获取会员等级
     * @param condition
     * @return
     */
    private String getMemberLevel(Integer condition){

        //获取等级的条件值
        List<MemberLevel> memberLevelList = memberLevelService.list();
        MemberLevel memberLevel[] = memberLevelList.toArray(new MemberLevel[0]);
        for (int i = 0; i < memberLevel.length; i++) {
            if (condition < memberLevel[i].getConditionGrowth()){
                return memberLevel[i].getLevelName();
            }
        }
        return "未知等级";
    }

    /**
     * 获取会员标签
     * @param memberID
     * @return
     */
    private String[] getMemberTag(String memberID){

        String[] memberTag;
        StringBuffer line = new StringBuffer();
        //从联合表中查询memberId的记录，并提取出同行的memberTagId的记录
        LambdaQueryWrapper<CombineMemberTag> combine = new LambdaQueryWrapper<>();
        combine.eq(CombineMemberTag::getMemberId,memberID);
        List<CombineMemberTag> combineResult = combineMemberTagService.list(combine);
        if (combineResult.isEmpty() || combineResult.size() == 0 ){
            return new String[]{"没有标签"};
        }
        ArrayList<Integer> memberTagIds = Lists.newArrayList();
        int i = 0;
        combineResult.forEach(combineMemberTag -> {
            memberTagIds.add(combineMemberTag.getTagId());
        });

        LambdaQueryWrapper<MemberTag> getMemberTag = new LambdaQueryWrapper<>();
        getMemberTag.in(MemberTag::getTagId,memberTagIds);

        List<MemberTag> memberTags = memberTagService.list();
        memberTags.forEach(memberTag1 -> {
            System.out.println(memberTag1);
            line.append(memberTag1.getTagName()+",");
        });

        memberTag = line.toString().split(",");
        return memberTag;
    }

    /**
     * 从订单表中获取总订单数量，和总消费金额
     * @param memberId
     * @param select_value 0代表提订单次数，1代表总消费金额
     * @return
     */
    private Integer getOrderAndOrderMoney(String memberId,int select_value){

        Integer value = 0;

        LambdaQueryWrapper<Order_record> orderQuery = new LambdaQueryWrapper<>();
        orderQuery.eq(Order_record::getMemberId,memberId);
        if (select_value == 0) {
            value = Math.toIntExact(orderService.count(orderQuery));
        }
        orderQuery.select(Order_record::getAmount);
        if (select_value == 1){
            value = Math.toIntExact(orderService.count(orderQuery));
        }

        return value;
    }
}
