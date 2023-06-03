package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.Member;
import com.auther.fan.member_system.sys.service.impl.MemberServiceImpl;
import com.auther.fan.member_system.util.QueryPageUtils;
import com.auther.fan.member_system.util.Result;
import com.auther.fan.member_system.vo.QueryMemberVo;
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
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberServiceImpl memberService;

    @GetMapping()
    public Result<?> ListMembers(){
        HashMap<String, Object> map = new HashMap<>();
        List<Member> data = memberService.list();
        map.put("data",data);
        return Result.success(data);
    }

    @GetMapping("/queryMember")
    public Result<?> ListQueryMemberVO(@RequestParam("pageSize") int pageSize,
                                                         @RequestParam("pageNum") int pageNum){
        HashMap<String, Object> map = new HashMap<>();
        List<QueryMemberVo> data= memberService.listQueryMember();
        //使用分页工具类进行分类
        IPage<QueryMemberVo> page = QueryPageUtils.getPage(data, pageNum, pageSize);
        System.out.println(page.getTotal());
        map.put("total",page.getTotal());
        map.put("records",page.getRecords());
        return Result.success(map);
    }
}
