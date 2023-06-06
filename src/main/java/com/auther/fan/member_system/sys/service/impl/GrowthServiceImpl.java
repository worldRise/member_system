package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Growth;
import com.auther.fan.member_system.sys.mapper.GrowthMapper;
import com.auther.fan.member_system.sys.service.IGrowthService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
public class GrowthServiceImpl extends ServiceImpl<GrowthMapper, Growth> implements IGrowthService {

    /**
     * 取出相应用于的成长值记录
     * @param memberId
     * @return
     */
    @Override
    public List<Growth> getOrderListByMemberId(String memberId) {

        LambdaQueryWrapper<Growth> growthQuery = new LambdaQueryWrapper<>();
        growthQuery.eq(Growth::getMemberId,memberId);

        return list(growthQuery);
    }
}
