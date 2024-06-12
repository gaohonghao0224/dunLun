package cn.iocoder.yudao.module.business.controller.app.order;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderPageReqVO;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderRespVO;
import cn.iocoder.yudao.module.business.controller.app.order.vo.OrderSaveReqVO;
import cn.iocoder.yudao.module.business.dal.dataobject.order.OrderDO;
import cn.iocoder.yudao.module.business.service.order.OrderFacadeService;
import cn.iocoder.yudao.module.business.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * 订单信息 Controller
 *
 * @author gaohonghao
 */
@Tag(name = "业务模块 - 订单信息")
@RestController
@RequestMapping("/business/order")
@Validated
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderFacadeService orderFacadeService;

    @GetMapping("/page")
    @Operation(summary = "获取订单分页列表")
    @PreAuthorize("@ss.hasPermission('business:order:query')")
    public CommonResult<PageResult<OrderRespVO>> getOrderList(OrderPageReqVO reqVO) {
        PageResult<OrderDO> list = orderService.getOrderPage(reqVO);
        return success(BeanUtils.toBean(list, OrderRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "查看订单详情")
    @PreAuthorize("@ss.hasPermission('business:order:query')")
    public CommonResult<OrderRespVO> getOrderDetail(Long id) {
        return success(orderFacadeService.getOrderDetail(id));
    }


    @PostMapping("create")
    @Operation(summary = "创建订单")
    @PreAuthorize("@ss.hasPermission('business:order:create')")
    public CommonResult<Boolean> createOrder(@Valid @RequestBody OrderSaveReqVO createReqVO) {
        orderService.createOrder(createReqVO);
        return success(true);
    }

    @PutMapping("update")
    @Operation(summary = "更新订单")
    @PreAuthorize("@ss.hasPermission('business:order:update')")
    public CommonResult<Boolean> updateOrder(@Valid @RequestBody OrderSaveReqVO updateReqVO) {
        orderService.updateOrder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("delete")
    @Operation(summary = "删除订单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('business:order:delete')")
    public CommonResult<Boolean> deleteOrder(@RequestParam("id") Long id) {
        orderService.deleteOrder(id);
        return success(true);
    }
}
