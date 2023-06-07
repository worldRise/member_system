package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.MemberLevel;
import com.auther.fan.member_system.sys.mapper.MemberLevelMapper;
import com.auther.fan.member_system.sys.service.IMemberLevelService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements IMemberLevelService {

    /**
     * 会员等级列表
     * @param levelName
     * @return
     */
    @Override
    public List<MemberLevel> getOrderListByMemberId(String levelName) {
        LambdaQueryWrapper<MemberLevel> memberQuery = new LambdaQueryWrapper<>();
        if (levelName != null) {
            memberQuery.eq(MemberLevel::getLevelName, levelName);
        }
        return list(memberQuery);
    }

    /**
     * 添加会员等级
     * @param memberLevel
     * @return
     */
    @Override
    public boolean saveMemberLevel(MemberLevel memberLevel) {
        LambdaQueryWrapper<MemberLevel> memQuery = new LambdaQueryWrapper<>();
        memQuery.eq(MemberLevel::getLevelName,memberLevel.getLevelName());
        List<MemberLevel> memberLevels = list(memQuery);
        if (memberLevels.size() != 0){
            return false;
        }
        return save(memberLevel);
    }

    /**
     * 配置会员等级
     * @param memberLevel
     * @return
     */
    @Override
    public boolean updateMemberLevel(MemberLevel memberLevel) {
        LambdaQueryWrapper<MemberLevel> memQuery = new LambdaQueryWrapper<>();
        memQuery.eq(MemberLevel::getLevelId,memberLevel.getLevelId());
        List<MemberLevel> memberLevels = list(memQuery);
        if (memberLevels.size() == 0){
            return false;
        }
        LambdaQueryWrapper<MemberLevel> memUpdate = new LambdaQueryWrapper<>();
        memUpdate.eq(MemberLevel::getLevelId,memberLevel.getLevelId());
        return update(memberLevel,memUpdate);
    }

    /**
     * 删除会员等级
     * @param levelId
     * @return
     */
    @Override
    public boolean deleteMemberLevelById(Integer levelId) {
        if (removeById(levelId)){
            return true;
        }
        return false;
    }


}
