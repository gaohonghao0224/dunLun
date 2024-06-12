package cn.iocoder.yudao.module.business.controller.app.product.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
@Accessors(chain = false)
public class ProductImportExcelVO {

    @ExcelProperty(value = "货架号")
    private String shelfNumber;

    @ExcelProperty("商品编码")
    private String productCode;

    @ExcelProperty("商品名称")
    private String productName;

    @ExcelProperty("进货价")
    private BigDecimal purchasePrice;

    @ExcelProperty("备注")
    private String remark;
}
