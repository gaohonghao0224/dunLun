package cn.iocoder.yudao.module.business.api.order;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.api.order.dto.OrderDTO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderDO;
import cn.iocoder.yudao.module.business.service.order.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 订单 api 接口实现类
 *
 * @author gaohonghao
 */
@Component
public class OrderApiImpl implements OrderApi {

    @Resource
    private OrderService orderService;

    /**
     * 根据 id 获取订单
     *
     * @param id 订单 ID
     * @return 订单 DTO
     */
    @Override
    public OrderDTO getOrderById(Long id) {
        OrderDO orderDO = orderService.getOrder(id);
        return BeanUtils.toBean(orderDO, OrderDTO.class);
    }
}
