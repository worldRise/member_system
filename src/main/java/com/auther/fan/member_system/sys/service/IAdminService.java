package com.auther.fan.member_system.sys.service;

import com.auther.fan.member_system.sys.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
public interface IAdminService extends IService<Admin> {

    HashMap<String, Object> login(Admin admin);
}
