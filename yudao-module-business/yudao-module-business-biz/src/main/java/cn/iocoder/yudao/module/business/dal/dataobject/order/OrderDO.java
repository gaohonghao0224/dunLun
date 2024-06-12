package cn.iocoder.yudao.module.business.dal.dataobject.order;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.module.business.emum.PlatformCategoryEnum;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表 DO
 *
 * @author gaohonghao
 */
@Data
@TableName("business_order")
@EqualsAndHashCode(callSuper = false)
public class OrderDO extends BaseDO {

    @TableId
    private Long id;

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
}
