package cn.iocoder.yudao.module.business.api.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    /**
     * 货架号
     */
    private String shelfNumber;

    /**
     * 商品编码
     */
    private String productCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;
}
