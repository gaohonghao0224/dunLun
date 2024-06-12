package cn.iocoder.yudao.module.business.controller.app.product;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.business.controller.app.product.vo.*;
import cn.iocoder.yudao.module.business.dal.dataobject.product.ProductDO;
import cn.iocoder.yudao.module.business.service.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "业务模块 - 商品信息")
@RestController
@RequestMapping("/business/product")
@Validated
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/page")
    @Operation(summary = "获取商品分页列表")
    @PreAuthorize("@ss.hasPermission('business:product:query')")
    public CommonResult<PageResult<ProductRespVO>> getProductList(ProductPageReqVO reqVO) {
        PageResult<ProductDO> list = productService.getProductPage(reqVO);
        return success(BeanUtils.toBean(list, ProductRespVO.class));
    }

    @PostMapping("create")
    @Operation(summary = "创建商品")
    @PreAuthorize("@ss.hasPermission('business:product:create')")
    public CommonResult<Long> createProduct(@Valid @RequestBody ProductSaveReqVO createReqVO) {
        Long productId = productService.createProduct(createReqVO);
        return success(productId);
    }

    @PutMapping("update")
    @Operation(summary = "更新商品")
    @PreAuthorize("@ss.hasPermission('business:product:update')")
    public CommonResult<Boolean> updateProduct(@Valid @RequestBody ProductUpdateReqVO updateReqVO) {
        productService.updateProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("delete")
    @Operation(summary = "删除商品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('business:product:delete')")
    public CommonResult<Boolean> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return success(true);
    }

    @PostMapping("/import")
    @Operation(summary = "导入商品")
    @Parameter(name = "file", description = "Excel 文件", required = true)
    @PreAuthorize("@ss.hasPermission('business:product:import')")
    public CommonResult<Boolean> importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        List<ProductImportExcelVO> list = ExcelUtils.read(file, ProductImportExcelVO.class);
        productService.importProductList(list);

        return success(true);
    }

}
