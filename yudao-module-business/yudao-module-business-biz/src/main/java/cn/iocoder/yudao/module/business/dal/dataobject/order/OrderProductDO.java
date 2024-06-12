package cn.iocoder.yudao.module.business.dal.dataobject.order;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 订单表和商品表关联表 DO
 *
 * @author gaohonghao
 */
@Data
@TableName("business_order_product")
public class OrderProductDO {

    @TableId
    private Long id;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 商品编号
     */
    private Long productId;

    /**
     * 商品数量
     */
    private Integer quantity;

}
