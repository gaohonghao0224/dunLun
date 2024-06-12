package cn.iocoder.yudao.module.business.dal.dataobject.product;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@TableName("business_product")
@EqualsAndHashCode(callSuper = false)
public class ProductDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;

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

    /**
     * 备注
     */
    private String remark;


}
