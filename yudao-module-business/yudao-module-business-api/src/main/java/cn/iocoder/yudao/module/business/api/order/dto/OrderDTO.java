package cn.iocoder.yudao.module.business.api.order.dto;

import cn.iocoder.yudao.module.business.emum.PlatformCategoryEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单 DTO
 *
 * @author gaohonghao
 */
@Data
public class OrderDTO {

    /**
     * 平台单号
     */
    private String platformOrderNumber;

    /**
     * 平台
     * <p>
     * 枚举 {@link PlatformCategoryEnum}
     */
    private Integer platform;

    /**
     * 是否刷单
     */
    private Boolean brushOrder;

    /**
     * 预计收入
     */
    private BigDecimal estimateIncome;

    /**
     * 收入时间
     */
    private LocalDateTime incomeTime;

    /**
     * 包装费
     */
    private BigDecimal packagingCost;

    /**
     * 货品成本
     */
    private BigDecimal goodsCost;

    /**
     * 履约服务费
     */
    private BigDecimal contractServiceFee;

    /**
     * 三方跑腿费
     */
    private String thirdPartyRider;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
