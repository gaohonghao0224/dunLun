package cn.iocoder.yudao.module.business.service.product;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductImportExcelVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductPageReqVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductSaveReqVO;
import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductUpdateReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.product.ProductDO;

import java.util.Collection;
import java.util.List;

/**
 * 商品 service 接口
 *
 * @author gaohonghao
 */
public interface ProductService {

    /**
     * 创建商品
     *
     * @param createReqVO 商品信息
     * @return 商品编号
     */
    Long createProduct(ProductSaveReqVO createReqVO);

    /**
     * 导入商品列表
     *
     * @param importRespVOList 导入列表
     */
    void importProductList(List<ProductImportExcelVO> importRespVOList);

    /**
     * 更新商品
     *
     * @param updateReqVO 商品信息
     */
    void updateProduct(ProductUpdateReqVO updateReqVO);

    /**
     * 删除商品
     *
     * @param id 商品编号
     */
    void deleteProduct(Long id);

    /**
     * 获得商品信息
     *
     * @param id 商品编号
     * @return 商品信息
     */
    ProductDO getProduct(Long id);

    /**
     * 获得商品分页列表
     *
     * @param pageReqVO 分页条件
     * @return 分页列表
     */
    PageResult<ProductDO> getProductPage(ProductPageReqVO pageReqVO);

    /**
     * 获取商品列表
     *
     * @param productIds 商品 ids
     * @return 商品列表
     */
    public List<ProductDO> getProductList(Collection<Long> productIds);


}
