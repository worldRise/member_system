package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.CombineMemberTag;
import com.auther.fan.member_system.sys.entity.MemberTag;
import com.auther.fan.member_system.sys.mapper.MemberTagMapper;
import com.auther.fan.member_system.sys.service.IMemberTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.RouteMatcher;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@Service
public class MemberTagServiceImpl extends ServiceImpl<MemberTagMapper, MemberTag> implements IMemberTagService {

    @Resource
    private CombineMemberTagServiceImpl combineMemberTagService;

    /**
     * 返回标签列表
     * @param tagType
     * @param tagName
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Map<Object,Object>> getOrderListByMemberId(String tagType, String tagName) {
        LambdaQueryWrapper<MemberTag> tagQuery = new LambdaQueryWrapper<>();
        if (tagType != null){
            tagQuery.eq(MemberTag::getTagType,tagType);
        }
        if (tagName != null){
            tagQuery.eq(MemberTag::getTagName,tagName);
        }
        ArrayList<Map<Object,Object>> result = Lists.newArrayList();
        List<MemberTag> list = list(tagQuery);
        //判断列表是否为空
        if (list.size() == 0){
            return null;
        }
        list.forEach(memberTag -> {
            HashMap<Object, Object> map = new HashMap<>();
            map.put(memberTag.getTagId(),memberTag);
            map.put("memberSum",getMemberSum(memberTag.getTagId()));
            result.add(map);
        });
        return result;
    }

    @Override
    public boolean saveMemberTag(MemberTag memberTag) {
        LambdaQueryWrapper<MemberTag> tagQuery = new LambdaQueryWrapper<>();
        tagQuery.eq(MemberTag::getTagName,memberTag.getTagName());
        List<MemberTag> list = list(tagQuery);
        if(list.size() != 0){
            return false;
        }

        return save(memberTag);
    }

    @Override
    public boolean updateMemberTag(MemberTag memberTag) {
        LambdaQueryWrapper<MemberTag> tagQuery = new LambdaQueryWrapper<>();
        tagQuery.eq(MemberTag::getTagId,memberTag.getTagId());
        List<MemberTag> list = list(tagQuery);
        if(list.size() == 0){
            return false;
        }
        LambdaUpdateWrapper<MemberTag> tagUpdate = new LambdaUpdateWrapper<>();
        tagUpdate.eq(MemberTag::getTagId,memberTag.getTagId());
        tagQuery.clear();
        tagQuery.eq(MemberTag::getTagName,memberTag.getTagName());
        list = list(tagQuery);
        if(list.size() != 0){
            return false;
        }
        return update(memberTag,tagUpdate);
    }

    @Override
    public boolean deleteMemberTag(Integer tagId) {
        return removeById(tagId);
    }

    private long getMemberSum(Integer tagId) {
        LambdaQueryWrapper<CombineMemberTag> comQuery = new LambdaQueryWrapper<>();
        comQuery.eq(CombineMemberTag::getTagId,tagId);
        return combineMemberTagService.count(comQuery);
    }
}
