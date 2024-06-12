package cn.iocoder.yudao.module.business.service.product;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductImportExcelVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductUpdateReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.module.business.dal.mysql.ProductMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Validated
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 获得商品信息
     *
     * @param id 商品编号
     * @return 商品信息
     */
    @Override
    public ProductDO getProduct(Long id) {
        return productMapper.selectById(id);
    }

    /**
     * 获得商品分页列表
     *
     * @param pageReqVO 分页条件
     * @return 分页列表
     */
    @Override
    public PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO) {

        return productMapper.selectPage(pageReqVO);
    }

    /**
     * 获取商品列表
     *
     * @param productIds 商品 ids
     * @return 商品列表
     */
    @Override
    public List<ProductDO> getProductList(Collection<Long> productIds) {

        if (CollUtil.isEmpty(productIds)) return Collections.emptyList();

        return productMapper.selectBatchIds(productIds);
    }

    /**
     * 创建商品
     *
     * @param createReqVO 商品信息
     * @return 商品编号
     */
    @Override
    public Long createProduct(ProductSaveReqVO createReqVO) {
        ProductDO product = BeanUtils.toBean(createReqVO, ProductDO.class);
        productMapper.insert(product);
        return product.getId();
    }

    /**
     * 导入商品列表
     *
     * @param importRespVOList 导入列表
     */
    @Override
    public void importProductList(List<ProductImportExcelVO> importRespVOList) {
        List<ProductDO> productDOList = BeanUtils.toBean(importRespVOList, ProductDO.class);
        productMapper.insertBatch(productDOList);
    }

    /**
     * 更新商品
     *
     * @param updateReqVO 商品信息
     */
    @Override
    public void updateProduct(ProductUpdateReqVO updateReqVO) {
        ProductDO product = BeanUtils.toBean(updateReqVO, ProductDO.class);
        productMapper.updateById(product);
    }

    /**
     * 删除商品
     *
     * @param id 商品编号
     */
    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteById(id);
    }

}
