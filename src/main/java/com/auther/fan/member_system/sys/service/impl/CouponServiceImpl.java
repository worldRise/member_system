package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Coupon;
import com.auther.fan.member_system.sys.mapper.CouponMapper;
import com.auther.fan.member_system.sys.service.ICouponService;
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
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {

    /**
     * 查询用户优惠券
     * @param memberId
     * @return
     */
    @Override
    public List<Coupon> getOrderListByMemberId(String memberId) {
        LambdaQueryWrapper<Coupon> couponQuery = new LambdaQueryWrapper<>();
        couponQuery.eq(Coupon::getMemberId,memberId);
        return list(couponQuery);
    }
}
