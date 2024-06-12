package cn.iocoder.yudao.module.business.dal.mysql;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderProductDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单商品关联表 mapper
 *
 * @author gaohonghao
 */
@Mapper
public interface OrderProductMapper extends BaseMapperX<OrderProductDO> {

}
