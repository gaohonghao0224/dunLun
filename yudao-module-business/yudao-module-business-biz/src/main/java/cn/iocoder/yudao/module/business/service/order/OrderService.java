package cn.iocoder.yudao.module.business.service.order;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderPageReqVO;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderSaveReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderDO;

/**
 * 订单 service 接口
 *
 * @author gaohonghao
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param createReqVO 订单信息
     * @return 订单编号
     */
    int createOrder(OrderSaveReqVO createReqVO);

    /**
     * 更新订单
     *
     * @param updateReqVO 订单信息
     */
    void updateOrder(OrderSaveReqVO updateReqVO);

    /**
     * 删除订单
     *
     * @param id 订单编号
     */
    void deleteOrder(Long id);

    /**
     * 获得订单信息
     *
     * @param id 订单编号
     * @return 订单信息
     */
    OrderDO getOrder(Long id);

    /**
     * 获得订单分页列表
     *
     * @param pageReqVO 分页条件
     * @return 分页列表
     */
    PageResult<OrderDO> getOrderPage(OrderPageReqVO pageReqVO);

}
