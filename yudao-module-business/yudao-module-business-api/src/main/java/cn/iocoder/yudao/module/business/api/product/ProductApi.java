package cn.iocoder.yudao.module.business.api.product;

import cn.iocoder.yudao.module.business.api.product.dto.ProductDTO;

public interface ProductApi {

    ProductDTO getProductById(Long id);

}
