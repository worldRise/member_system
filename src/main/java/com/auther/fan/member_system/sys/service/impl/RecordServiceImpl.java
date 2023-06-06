package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Record;
import com.auther.fan.member_system.sys.mapper.RecordMapper;
import com.auther.fan.member_system.sys.service.IRecordService;
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
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    /**
     * 获取用户储值记录
     * @param memberId
     * @return
     */
    @Override
    public List<Record> getOrderListByMemberId(String memberId) {
        LambdaQueryWrapper<Record> recordQuery = new LambdaQueryWrapper<>();
        recordQuery.eq(Record::getMemberId,memberId);

        return list(recordQuery);
    }
}
