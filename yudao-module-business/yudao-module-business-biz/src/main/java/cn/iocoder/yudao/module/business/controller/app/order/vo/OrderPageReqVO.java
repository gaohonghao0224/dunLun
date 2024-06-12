package cn.iocoder.yudao.module.business.controller.app.order.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 订单分页列表 Request VO
 *
 * @author gaohonghao
 */
@Schema(description = "订单信息 - 分页列表 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPageReqVO extends PageParam {

    @Schema(description = "平台", requiredMode = Schema.RequiredMode.AUTO, example = "1（美团）")
    private String platform;

    @Schema(description = "收入时间", requiredMode = Schema.RequiredMode.AUTO, example = "时间内容")
    private LocalDateTime incomeTime;

    @Schema(description = "是否刷单", requiredMode = Schema.RequiredMode.AUTO, example = "true")
    private Boolean brushOrder;


}
