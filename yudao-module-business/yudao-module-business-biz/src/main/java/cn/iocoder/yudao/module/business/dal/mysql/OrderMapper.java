package cn.iocoder.yudao.module.business.dal.mysql;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderPageReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表 Mapper
 * @author gaohonghao
 */
@Mapper
public interface OrderMapper extends BaseMapperX<OrderDO> {

    default PageResult<OrderDO> selectPage(OrderPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<OrderDO>()
                .eqIfPresent(OrderDO::getPlatform,pageReqVO.getPlatform())
                .eqIfPresent(OrderDO::getBrushOrder, pageReqVO.getBrushOrder()));
    }

}
