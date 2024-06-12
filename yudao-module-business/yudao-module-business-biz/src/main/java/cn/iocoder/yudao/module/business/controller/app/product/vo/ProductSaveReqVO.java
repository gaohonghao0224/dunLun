package cn.iocoder.yudao.module.business.controller.app.product.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商品信息 - 新增商品信息 Request VO
 * @author gaohonghao
 */
@Schema(description = "商品信息 - 新增商品信息 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveReqVO {

    @Schema(description = "货架号", requiredMode = Schema.RequiredMode.REQUIRED, example = "A01")
    private String shelfNumber;

    @Schema(description = "商品编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "970224")
    private String productCode;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "大象")
    private String productName;

    @Schema(description = "进货价", requiredMode = Schema.RequiredMode.REQUIRED, example = "20.00")
    private BigDecimal purchasePrice;

    @Schema(description = "备注", requiredMode = Schema.RequiredMode.REQUIRED, example = "备注信息")
    private String remark;
}
