package cn.iocoder.yudao.module.business.service.order;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderRespVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductRespVO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderDO;
import cn.iocoder.yudao.module.business.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.module.business.service.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 订单 service 门面类
 *
 * @author gaohonghao
 */
@Service
public class OrderFacadeService {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderProductService orderProductService;

    @Resource
    private ProductService productService;

    /**
     * 获取订单详细信息
     *
     * @param orderId 订单 ID
     * @return 订单详细信息
     */
    public OrderRespVO getOrderDetail(Long orderId) {

        OrderDO orderDO = orderService.getOrder(orderId);

        Set<Long> productIds = orderProductService.listProductByOrderId(orderId);

        List<ProductDO> productList = productService.getProductList(productIds);

        // 转变为 VO 类并注入
        OrderRespVO orderRespVO = BeanUtils.toBean(orderDO, OrderRespVO.class);
        orderRespVO.setProductRespVOList(BeanUtils.toBean(productList, ProductRespVO.class));

        return orderRespVO;
    }

}
