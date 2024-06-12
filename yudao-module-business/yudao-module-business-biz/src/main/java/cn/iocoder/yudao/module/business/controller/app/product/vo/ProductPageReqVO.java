package cn.iocoder.yudao.module.business.controller.app.product.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "商品信息 - 分页列表 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductPageReqVO extends PageParam {

    @Schema(description = "货架号", requiredMode = Schema.RequiredMode.REQUIRED, example = "A01")
    private String shelfNumber;

    @Schema(description = "商品编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "970224")
    private String productCode;

    @Schema(description = "商品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "大象")
    private String productName;

}
