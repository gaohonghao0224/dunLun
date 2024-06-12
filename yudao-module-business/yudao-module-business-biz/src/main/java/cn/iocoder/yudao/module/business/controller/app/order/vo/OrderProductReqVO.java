package cn.iocoder.yudao.module.business.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "订单商品关联表 - 订单商品关联 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductReqVO {

    @Schema(description = "订单编号ID")
    private Long orderId;

    @Schema(description = "商品ID")
    private Long productId;
}
