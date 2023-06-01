package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.Admin;
import com.auther.fan.member_system.sys.service.impl.AdminServiceImpl;
import com.auther.fan.member_system.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/")
public class AdminController {

    @Resource
    private AdminServiceImpl adminService;

    @GetMapping("/")
    public Result<?> Test(){
        HashMap<String, Object> data = new HashMap<>();
        List<Admin> list = adminService.list();
        data.put("data",list);
        return Result.success(data);
    }

}
