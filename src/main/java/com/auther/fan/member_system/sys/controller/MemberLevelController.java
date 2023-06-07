package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.MemberLevel;
import com.auther.fan.member_system.sys.entity.Record;
import com.auther.fan.member_system.sys.service.impl.MemberLevelServiceImpl;
import com.auther.fan.member_system.sys.service.impl.RecordServiceImpl;
import com.auther.fan.member_system.util.QueryPageUtils;
import com.auther.fan.member_system.util.Result;
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
@RequestMapping("/memberLevel")
public class MemberLevelController {

    @Resource
    private MemberLevelServiceImpl memberLevelService;

    /**
     * 获取会员等级列表
     * @param pageSize
     * @param pageNum
     * @param levelName
     * @return
     */

    @GetMapping("/getListByLevelName")
    public Result<?> getListByMemberId(@RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("pageNum") Integer pageNum,
                                           @RequestParam(value = "levelName",required = false ) String levelName){
        HashMap<String, Object> map = new HashMap<>();
        List<MemberLevel> memberLevels = memberLevelService.getOrderListByMemberId(levelName);
        if (memberLevels == null){
            return Result.success("没有名称为+"+levelName+"+的会员等级");
        }
        IPage<MemberLevel> data = QueryPageUtils.getPage(memberLevels, pageNum, pageSize);
        map.put("total",data.getTotal());
        map.put("data",data.getRecords());
        return Result.success(map);
    }

    /**
     * 添加
     * @param memberLevel
     * @return
     */
    @PostMapping
    public Result<?> addMemberLevel(@RequestBody MemberLevel memberLevel){
        if (!memberLevelService.saveMemberLevel(memberLevel)){
            return Result.fail("添加失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 修改
     * @param memberLevel
     * @return
     */
    @PutMapping
    public Result<?> updateMemberLevel(@RequestBody MemberLevel memberLevel){
        if (!memberLevelService.updateMemberLevel(memberLevel)){
            return Result.fail("修改失败");
        }
        return Result.success("修改成功");
    }

    /**
     * 删除
     * @param levelId
     * @return
     */
    @DeleteMapping
    public Result<?> deleteMemberLevelById(@RequestParam("levelId") Integer levelId){
        if (!memberLevelService.deleteMemberLevelById(levelId)){
            return Result.fail("修改失败");
        }
        return Result.success("修改成功");
    }
}
