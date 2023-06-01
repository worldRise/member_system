package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Member;
import com.auther.fan.member_system.sys.mapper.MemberMapper;
import com.auther.fan.member_system.sys.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
