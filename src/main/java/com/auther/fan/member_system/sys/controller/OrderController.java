package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.OrderRecord;
import com.auther.fan.member_system.sys.service.impl.OrderServiceImpl;
import com.auther.fan.member_system.util.QueryPageUtils;
import com.auther.fan.member_system.util.Result;
import com.auther.fan.member_system.vo.OrderRecordVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderServiceImpl orderService;

    /**
     * 查询会员订单记录
     * @param memberId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping("/getListByMemberId")
    public Result<?> getOrderListByMemberId(@RequestParam("memberId") String memberId,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("pageNum") Integer pageNum){
        HashMap<String, Object> map = new HashMap<>();
        List<OrderRecordVO> recordVOS = orderService.getOrderListByMemberId(memberId);
        if (recordVOS == null){
            return Result.success("没有订单记录");
        }
        IPage<OrderRecordVO> data = QueryPageUtils.getPage(recordVOS, pageNum, pageSize);
        map.put("total",data.getTotal());
        map.put("data",data.getRecords());
        return Result.success(map);
    }

    @PutMapping("/updateShipmentStatus")
    public Result<?> updateShipmentStatus(@RequestBody OrderRecord orderRecord){

        if (!orderService.updateShipmentStatus(orderRecord)){
            return Result.fail("发送货物失败！");
        }
        return Result.success("发送货物成功！");

    }
}
