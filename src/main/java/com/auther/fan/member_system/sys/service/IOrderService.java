package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.OrderRecord;
import com.auther.fan.member_system.vo.OrderRecordVO;
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
public interface IOrderService extends IService<OrderRecord> {

    List<OrderRecordVO> getOrderListByMemberId(String memberId);

    boolean updateShipmentStatus(OrderRecord orderRecord);
}
