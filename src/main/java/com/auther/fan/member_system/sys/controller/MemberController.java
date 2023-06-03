package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.Member;
import com.auther.fan.member_system.sys.service.impl.MemberServiceImpl;
import com.auther.fan.member_system.util.PhoneNumberGenerator;
import com.auther.fan.member_system.util.QueryPageUtils;
import com.auther.fan.member_system.util.Result;
import com.auther.fan.member_system.vo.QueryMemberVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
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
    public Result<?> ListMembers() {
        HashMap<String, Object> map = new HashMap<>();
        List<Member> data = memberService.list();
        map.put("data", data);
        return Result.success(data);
    }

    /**
     * 会员查询页面列表数据
     * @param pageSize 页大小
     * @param pageNum 页码
     * @param branch 所属门店
     * @param orderNum 下单次数
     * @param createTime 会员创建时间
     * @return
     */
    @GetMapping("/queryMember")
    public Result<?> ListQueryMemberVO(@RequestParam("pageSize") int pageSize,
                                       @RequestParam("pageNum") int pageNum,
                                       @RequestParam(value = "branch",required = false) Integer branch,
                                       @RequestParam(value = "orderNum",required = false) Integer[] orderNum,
                                       @RequestParam(value = "createTime",required = false) String createTime) {
        HashMap<String, Object> map = new HashMap<>();
        List<QueryMemberVo> data = memberService.listQueryMember(branch,orderNum,createTime);
        //使用分页工具类进行分类
        IPage<QueryMemberVo> page = QueryPageUtils.getPage(data, pageNum, pageSize);
        System.out.println(page.getTotal());
        map.put("total", page.getTotal());
        map.put("records", page.getRecords());
        return Result.success(map);
    }

    /**
     * 添加会员用户
     * @param member
     * @return
     */
    @PostMapping
    public Result<?> saveMember(@RequestBody Member member){

        try {
            //使用设置工具类设置主键Id，如果主键Id重复，就通过多次随机避免重复
            member.setMemberId(PhoneNumberGenerator.generateRandomId(member.getPhone()));
            memberService.save(member);
        } catch (Exception e) {
            saveMember(member);
        }
        return Result.success("添加会员成功");
    }

    @PutMapping("/score")
    public Result<?> updateScore(@RequestParam("memberId") String memberId){
        if(!memberService.updateScore(memberId)){

        }
        return Result.success("积分增加成功！");
    }

}
