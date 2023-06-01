package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Product;
import com.auther.fan.member_system.sys.mapper.ProductMapper;
import com.auther.fan.member_system.sys.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
