package com.auther.fan.member_system.sys.controller;

import com.auther.fan.member_system.sys.entity.Admin;
import com.auther.fan.member_system.sys.service.IAdminService;
import com.auther.fan.member_system.sys.service.impl.AdminServiceImpl;
import com.auther.fan.member_system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IAdminService adminService;

    @GetMapping("/")
    public Result<?> Test() {
        HashMap<String, Object> data = new HashMap<>();
        List<Admin> list = adminService.list();
        data.put("data", list);
        return Result.success(data);
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody Admin admin) {
        HashMap<String, Object> data = adminService.login(admin);
        if (data.isEmpty()) {
            return Result.fail("账号或密码不正确！");
        }
        return Result.success(data);
    }

}
