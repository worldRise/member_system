package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Score;
import com.auther.fan.member_system.sys.mapper.ScoreMapper;
import com.auther.fan.member_system.sys.service.IScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    @Override
    public List<Score> getOrderListByMemberId(String memberId) {
        LambdaQueryWrapper<Score> scoreQuery = new LambdaQueryWrapper<>();
        scoreQuery.eq(Score::getMemberId,memberId);

        return list(scoreQuery);
    }
}
