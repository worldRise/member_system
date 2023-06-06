package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.Record;
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
public interface IRecordService extends IService<Record> {

    List<Record> getOrderListByMemberId(String memberId);
}
