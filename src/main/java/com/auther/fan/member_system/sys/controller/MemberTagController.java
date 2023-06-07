package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.MemberTag;
import com.auther.fan.member_system.sys.entity.Record;
import com.auther.fan.member_system.sys.service.impl.MemberTagServiceImpl;
import com.auther.fan.member_system.util.QueryPageUtils;
import com.auther.fan.member_system.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@RestController
@RequestMapping("/memberTag")
public class MemberTagController {

    @Resource
    private MemberTagServiceImpl memberTagService;

    @GetMapping
    public Result<?> getMemberTagList(@RequestParam("pageSize") Integer pageSize,
                                      @RequestParam("pageNum") Integer pageNum,
                                      @RequestParam(value = "tagType", required = false) String tagType,
                                      @RequestParam(value = "tagName", required = false) String tagName) {

        HashMap<Object, Object> map = new HashMap<>();
        List<Map<Object,Object>> memberTags = memberTagService.getOrderListByMemberId(tagType,tagName);
        if (memberTags == null){
            return Result.success("没有这些记录");
        }
        IPage<Map<Object,Object>> data = QueryPageUtils.getPage(memberTags, pageNum, pageSize);
        map.put("total",data.getTotal());
        map.put("data",data.getRecords());
        return Result.success(map);
    }

    @PostMapping
    public Result<?> saveMemberTag(@RequestBody MemberTag memberTag){
        if (!memberTagService.saveMemberTag(memberTag)){
            return Result.fail("添加标签失败");
        }
        return Result.success("添加标签成功");
    }

    @PutMapping
    public Result<?> updateMemberTag(@RequestBody MemberTag memberTag){
        if (!memberTagService.updateMemberTag(memberTag)){
            return Result.fail("修改标签失败");
        }
        return Result.success("修改标签成功");
    }

    @DeleteMapping
    public Result<?> deleteMemberTag(@RequestParam("tagId") Integer tagId){
        if (!memberTagService.deleteMemberTag(tagId)){
            return Result.fail("删除标签失败");
        }
        return Result.success("删除标签成功");
    }

}
