package cn.iocoder.yudao.module.business.service.order;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderPageReqVO;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderSaveReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderDO;
import cn.iocoder.yudao.module.business.dal.mysql.OrderMapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 订单 service 实现类
 *
 * @author gaohonghao
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderProductService orderProductService;


    /**
     * 创建订单
     *
     * @param createReqVO 订单信息
     * @return 条数
     */
    @Override
    public int createOrder(OrderSaveReqVO createReqVO) {
        // 预先生成雪花算法 id
        createReqVO.setId(IdWorker.getId());

        // 新增商品关系表内容
        orderProductService.batchCreateOrderProduct(createReqVO.getOrderProductList());

        // 新增订单内容
        OrderDO orderDO = BeanUtils.toBean(createReqVO, OrderDO.class);

        return orderMapper.insert(orderDO);
    }

    /**
     * 更新订单
     *
     * @param updateReqVO 订单信息
     */
    @Override
    public void updateOrder(OrderSaveReqVO updateReqVO) {
        OrderDO orderDO = BeanUtils.toBean(updateReqVO, OrderDO.class);

        // 关系表先删除在新增
        orderProductService.deleteOrderProductByOrderId(updateReqVO.getId());
        orderProductService.batchCreateOrderProduct(updateReqVO.getOrderProductList());

        orderMapper.updateById(orderDO);
    }

    /**
     * 删除订单
     *
     * @param id 订单编号
     */
    @Override
    public void deleteOrder(Long id) {
        orderProductService.deleteOrderProductByOrderId(id);
        orderMapper.deleteById(id);
    }

    /**
     * 获得订单详细信息
     *
     * @param id 订单编号
     * @return 订单信息
     */
    @Override
    public OrderDO getOrder(Long id) {
        return orderMapper.selectById(id);
    }

    /**
     * 获得订单分页列表
     *
     * @param pageReqVO 分页条件
     * @return 分页列表
     */
    @Override
    public PageResult<OrderDO> getOrderPage(OrderPageReqVO pageReqVO) {
        return orderMapper.selectPage(pageReqVO);
    }
}
