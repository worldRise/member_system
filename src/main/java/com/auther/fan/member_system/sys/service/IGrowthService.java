package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.Growth;
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
public interface IGrowthService extends IService<Growth> {

    List<Growth> getOrderListByMemberId(String memberId);
}
