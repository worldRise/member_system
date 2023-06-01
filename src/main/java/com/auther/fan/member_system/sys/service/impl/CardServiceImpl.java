package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Card;
import com.auther.fan.member_system.sys.mapper.CardMapper;
import com.auther.fan.member_system.sys.service.ICardService;
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
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements ICardService {

}
