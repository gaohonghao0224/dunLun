package cn.iocoder.yudao.module.business.api.order;

import cn.iocoder.yudao.module.business.api.order.dto.OrderDTO;

/**
 * 订单信息 Api 接口
 *
 * @author gaohonghao
 */
public interface OrderApi {

    /**
     * 根据 id 获取订单
     *
     * @param id 订单 ID
     * @return 订单 DTO
     */
     OrderDTO getOrderById(Long id);
}
