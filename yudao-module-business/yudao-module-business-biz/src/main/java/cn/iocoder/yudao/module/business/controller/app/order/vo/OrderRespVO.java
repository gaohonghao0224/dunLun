package cn.iocoder.yudao.module.business.controller.app.order.vo;

import cn.iocoder.yudao.module.business.controller.app.product.vo.ProductRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author gaohonghao
 */
@Schema(description = "订单信息 - 订单 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRespVO {

    @Schema(description = "平台单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456789")
    private String platformOrderNumber;

    @Schema(description = "平台，枚举 { PlatformCategoryEnum }", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer platform;

    @Schema(description = "是否刷单", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean brushOrder;

    @Schema(description = "预计收入", example = "100.00")
    private BigDecimal estimateIncome;

    @Schema(description = "收入时间", example = "2023-06-01T12:00:00")
    private LocalDateTime incomeTime;

    @Schema(description = "包装费", example = "0.10")
    private BigDecimal packagingCost;

    @Schema(description = "货品成本", example = "50.00")
    private BigDecimal goodsCost;

    @Schema(description = "履约服务费", example = "5.00")
    private BigDecimal contractServiceFee;

    @Schema(description = "三方跑腿费", example = "2.00")
    private String thirdPartyRider;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-06-01T12:00:00")
    private LocalDateTime createTime;

    @Schema(description = "商品列表", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ProductRespVO> productRespVOList;

}
