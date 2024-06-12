package cn.iocoder.yudao.module.business.service.order;

import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderProductSaveVO;

import java.util.List;
import java.util.Set;

/**
 * 订单商品关联表 service 接口
 *
 * @author gaohonghao
 */
public interface OrderProductService {

    /**
     * 批量创建订单商品关系表
     *
     * @param createReqVOList 订单商品信息列表
     */
    void batchCreateOrderProduct(List<OrderProductSaveVO> createReqVOList);

    /**
     * 根据订单查询查询商品信息
     *
     * @param orderId 订单ID
     * @return 商品列表
     */
    Set<Long> listProductByOrderId(Long orderId);

    /**
     * 根据订单删除关系表信息
     *
     * @param orderId 订单ID
     */
    void deleteOrderProductByOrderId(Long orderId);
}
