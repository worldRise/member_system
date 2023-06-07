package com.auther.fan.member_system.sys.service.impl;

import com.auther.fan.member_system.sys.entity.Member;
import com.auther.fan.member_system.sys.entity.OrderRecord;
import com.auther.fan.member_system.sys.entity.Product;
import com.auther.fan.member_system.sys.mapper.OrderMapper;
import com.auther.fan.member_system.sys.service.IOrderService;
import com.auther.fan.member_system.vo.OrderRecordVO;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Synchronized;
import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fan
 * @since 2023-06-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderRecord> implements IOrderService {

    /**
     * 返回用户的订单列表
     * @param memberId
     * @return
     */
    @Resource
    private ProductServiceImpl productService;
    @Resource
    @Lazy //延迟加载，不然会造成循环依赖
    private MemberServiceImpl memberService;
    @Override
    public List<OrderRecordVO> getOrderListByMemberId(String memberId) {

        LambdaQueryWrapper<OrderRecord> orderQuery = new LambdaQueryWrapper<>();
        orderQuery.eq(OrderRecord::getMemberId,memberId)
                .eq(OrderRecord::getDeleted,0);
        List<OrderRecord> orderList = list(orderQuery);
        if (orderList.isEmpty()){
            return null;
        }
        List<OrderRecordVO> orderRecordVOS = Lists.newArrayList();
        orderList.forEach(orderRecord -> {
            OrderRecordVO orderRecordVO = orderRecordVOContent(orderRecord);
            orderRecordVOS.add(orderRecordVO);
        });
        return orderRecordVOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateShipmentStatus(OrderRecord orderRecord) {
        LambdaUpdateWrapper<OrderRecord> orderUpdate = new LambdaUpdateWrapper<>();
        orderUpdate.eq(OrderRecord::getOrderId,orderRecord.getOrderId())
                .set(OrderRecord::getShipmentStatus,1)
                .set(OrderRecord::getDeliveryMethod,orderRecord.getDeliveryMethod())
                .set(OrderRecord::getDeliveryId,orderRecord.getDeliveryId());

        return update(null,orderUpdate);
    }

    /**
     * 获取订单列表
     * @param orderRecord
     * @return
     */
    @Override
    public List<OrderRecordVO> getOrderList(OrderRecord orderRecord) {
        LambdaQueryWrapper<OrderRecord> orderQuery = new LambdaQueryWrapper<>();
        orderQuery.eq(StringUtils.hasLength(orderRecord.getOrderType()),OrderRecord::getOrderType,orderRecord.getOrderType())
                .eq(orderRecord.getShipmentStatus() != null ,OrderRecord::getShipmentStatus, orderRecord.getShipmentStatus())
                .eq(orderRecord.getPlacedAt() != null,OrderRecord::getPlacedAt,orderRecord.getPlacedAt())
                .eq(StringUtils.hasLength(orderRecord.getDeliveryMethod()),OrderRecord::getDeliveryMethod, orderRecord.getDeliveryMethod())
                .eq(StringUtils.hasLength(orderRecord.getPaymentMethod()),OrderRecord::getPaymentMethod, orderRecord.getPaymentMethod())
                .eq(orderRecord.getDeliveryId() != null,OrderRecord::getDeliveryId,orderRecord.getDeliveryId())
                .eq(StringUtils.hasLength(orderRecord.getOrderId()),OrderRecord::getOrderId, orderRecord.getOrderId())
                .eq(OrderRecord::getDeleted,0);
        List<OrderRecord> orderList = list(orderQuery);
        List<OrderRecordVO> orderRecordVOS = Lists.newArrayList();
        orderList.forEach(orderRecord1 -> {
            OrderRecordVO orderRecordVO = orderRecordVOContent(orderRecord1);
            orderRecordVOS.add(orderRecordVO);
        });

        return orderRecordVOS;
    }

    @Override
    public boolean removeLogic(String orderId) {
        LambdaUpdateWrapper<OrderRecord> orderUpdate = new LambdaUpdateWrapper<>();
        orderUpdate.eq(OrderRecord::getOrderId,orderId)
                .set(OrderRecord::getDeleted,1);
        return update(orderUpdate);
    }

    /**
     * 将实体类转换成前端需要的数据集合的VO类
     * @param orderRecord
     * @return
     */
    private OrderRecordVO orderRecordVOContent(OrderRecord orderRecord) {
        OrderRecordVO orderRecordVO = new OrderRecordVO();
        //获取商品信息
        Product product = getProduct(orderRecord.getProductId());
        //用户信息
        Member member = getMember(orderRecord.getMemberId());

        orderRecordVO.setOrderId(orderRecord.getOrderId());
        orderRecordVO.setPlacedAt(orderRecord.getPlacedAt());
        orderRecordVO.setPaymentMethod(orderRecord.getPaymentMethod());
        orderRecordVO.setNumber(orderRecord.getNumber());
        orderRecordVO.setOrderSource(orderRecord.getOrderSource());
        orderRecordVO.setDeliveryMethod(orderRecordVO.getDeliveryMethod());
        orderRecordVO.setShipmentStatus(orderRecordVO.getShipmentStatus());
        orderRecordVO.setProductName(product.getProductName());
        orderRecordVO.setOnePrice(product.getPrice());
        orderRecordVO.setSumPrice(product.getPrice() * orderRecord.getNumber());
        orderRecordVO.setMemberName(member.getName());
        orderRecordVO.setMemberPhone(member.getPhone());
        return orderRecordVO;
    }

    /**
     * 获取用户信息
     * @param memberId
     * @return
     */
    private Member getMember(String memberId) {
        LambdaQueryWrapper<Member> memberQuery = new LambdaQueryWrapper<>();
        memberQuery.eq(Member::getMemberId,memberId);
        return memberService.getOne(memberQuery);
    }

    /**
     * 获得订单信息
     * @param productId
     * @return
     */
    private Product getProduct(Integer productId){

        LambdaQueryWrapper<Product> productQuery = new LambdaQueryWrapper<>();
        productQuery.eq(Product::getProductId,productId);
        return productService.getOne(productQuery);
    }
}
