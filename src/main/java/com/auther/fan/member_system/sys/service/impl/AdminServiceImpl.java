package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Admin;
import com.auther.fan.member_system.sys.mapper.AdminMapper;
import com.auther.fan.member_system.sys.service.IAdminService;
import com.auther.fan.member_system.util.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {


    /**
     * 检查登录用户账号密码是否正确，如果正确返回token
     * @param admin
     * @return
     */
    @Override
    public HashMap<String, Object> login(Admin admin) {
        HashMap<String, Object> data = new HashMap<>();

        LambdaQueryWrapper<Admin> adminQuery = new LambdaQueryWrapper<>();
        adminQuery.eq(Admin::getUsername,admin.getUsername())
                .eq(Admin::getPassword,admin.getPassword());
        Admin loginAdmin = getOne(adminQuery);
        if (loginAdmin == null){
            return null;
        }
        //使用用模拟token方便使用接口测试工具统一进行测试
        String token = JwtUtils.jwtEncode(admin);
        //模拟token设置allow
        data.put("token","allow");
        return data;
    }
}
