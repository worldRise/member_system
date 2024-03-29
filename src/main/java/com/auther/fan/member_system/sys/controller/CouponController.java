package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.Coupon;
import com.auther.fan.member_system.sys.entity.Record;
import com.auther.fan.member_system.sys.service.impl.CouponServiceImpl;
import com.auther.fan.member_system.sys.service.impl.RecordServiceImpl;
import com.auther.fan.member_system.util.QueryPageUtils;
import com.auther.fan.member_system.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Resource
    private CouponServiceImpl couponService;

    /**
     * 获取优惠券列表
     * @param memberId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping("/getListByMemberId")
    public Result<?> geScoreListByMemberId(@RequestParam("memberId") String memberId,
                                           @RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("pageNum") Integer pageNum){
        HashMap<String, Object> map = new HashMap<>();
        List<Coupon> coupons = couponService.getOrderListByMemberId(memberId);
        if (coupons == null){
            return Result.success("没有优惠券");
        }
        IPage<Coupon> data = QueryPageUtils.getPage(coupons, pageNum, pageSize);
        map.put("total",data.getTotal());
        map.put("data",data.getRecords());
        return Result.success(map);
    }
}
