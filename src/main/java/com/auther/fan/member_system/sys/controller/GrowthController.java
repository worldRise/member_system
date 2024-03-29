package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.Growth;
import com.auther.fan.member_system.sys.entity.Score;
import com.auther.fan.member_system.sys.service.impl.GrowthServiceImpl;
import com.auther.fan.member_system.sys.service.impl.ScoreServiceImpl;
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
@RequestMapping("/growth")
public class GrowthController {

    @Resource
    private GrowthServiceImpl growthService;

    /**
     * 取出用户的相应成长值记录表
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
        List<Growth> growths = growthService.getOrderListByMemberId(memberId);
        if (growths == null || growths.isEmpty()){
            return Result.success("没有订单记录");
        }
        IPage<Growth> data = QueryPageUtils.getPage(growths, pageNum, pageSize);
        map.put("total",data.getTotal());
        map.put("data",data.getRecords());
        return Result.success(map);
    }
}
