package cn.iocoder.yudao.module.business.service.order;

import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderProductSaveVO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderProductDO;
import cn.iocoder.yudao.module.business.dal.mysql.OrderProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 订单商品关联表 service 实现类
 *
 * @author gaohonghao
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Resource
    private OrderProductMapper orderProductMapper;

    /**
     * 创建订单商品关系表
     *
     * @param createReqVOList 订单商品信息列表
     */
    @Override
    public void batchCreateOrderProduct(List<OrderProductSaveVO> createReqVOList) {
        List<OrderProductDO> orderProductDOList = BeanUtils.toBean(createReqVOList, OrderProductDO.class);
        orderProductMapper.insertBatch(orderProductDOList);
    }

    /**
     * 根据订单 ID 查询商品信息 ID
     *
     * @param orderId 订单ID
     * @return 商品列表
     */
    @Override
    public Set<Long> listProductByOrderId(Long orderId) {
        return CollectionUtils.convertSet( orderProductMapper.selectList(OrderProductDO::getOrderId, orderId), OrderProductDO::getProductId);
    }

    /**
     * 根据订单删除关系表信息
     *
     * @param orderId 订单ID
     */
    @Override
    public void deleteOrderProductByOrderId(Long orderId) {
        orderProductMapper.delete(OrderProductDO::getOrderId, orderId);
    }
}
