package cn.iocoder.yudao.module.business.dal.mysql;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.product.ProductDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapperX<ProductDO> {

    default PageResult<ProductDO> selectPage(ProductPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<ProductDO>()
                .likeIfPresent(ProductDO::getProductName, pageReqVO.getProductName())
                .eqIfPresent(ProductDO::getProductCode,pageReqVO.getProductCode())
                .eqIfPresent(ProductDO::getShelfNumber, pageReqVO.getShelfNumber()));
    }

}
