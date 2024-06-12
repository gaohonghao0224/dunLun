package cn.iocoder.yudao.module.business.api.product;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.api.product.dto.ProductDTO;
import cn.iocoder.yudao.module.business.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.module.business.service.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ProductApiImpl implements ProductApi{

    @Resource
    private ProductService productService;

    @Override
    public ProductDTO getProductById(Long id) {
        ProductDO productDO = productService.getProduct(id);
        return BeanUtils.toBean(productDO, ProductDTO.class);
    }
}
