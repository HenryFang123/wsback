package fzz.wsback.controller;

import fzz.wsback.domain.OrderInfo;
import fzz.wsback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author FH
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 订单操作控制层
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfoByOrderId", method = RequestMethod.POST)
    public List<OrderInfo> getOrderInfoByOrderId(@RequestParam(value = "orderId", required = false) String orderId) {
        return orderService.getOrderInfoByOrderId(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfoListByUserId", method = RequestMethod.POST)
    public List<OrderInfo> getOrderInfoListByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return orderService.getOrderInfoListByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getNotDeliverOrderInfoByUserId", method = RequestMethod.POST)
    public List<OrderInfo> getNotDeliverOrderInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return orderService.getNotDeliverOrderInfoByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getNotSignOrderInfoByUserId", method = RequestMethod.POST)
    public List<OrderInfo> getNotSignOrderInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return orderService.getNotSignOrderInfoByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getCancelOrderInfoByUserId", method = RequestMethod.POST)
    public List<OrderInfo> getCancelOrderInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return orderService.getCancelOrderInfoByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getDoneOrderInfoByUserId", method = RequestMethod.POST)
    public List<OrderInfo> getDoneOrderInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return orderService.getDoneOrderInfoByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfoListByBusinessId", method = RequestMethod.POST)
    public List<OrderInfo> getOrderInfoListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                        @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return orderService.getOrderInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getPayOrderInfoListByBusinessId", method = RequestMethod.POST)
    public List<OrderInfo> getPayOrderInfoListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                           @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return orderService.getPayOrderInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getSendOrderInfoListByBusinessId", method = RequestMethod.POST)
    public List<OrderInfo> getSendOrderInfoListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                           @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return orderService.getSendOrderInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getReturnOrderInfoListByBusinessId", method = RequestMethod.POST)
    public List<OrderInfo> getReturnOrderInfoListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                            @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return orderService.getReturnOrderInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getReturnOrderInfoCountByBusinessId", method = RequestMethod.POST)
    public Long getReturnOrderInfoCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return orderService.getReturnOrderInfoCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfoCountByBusinessId", method = RequestMethod.POST)
    public Long getOrderInfoCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return orderService.getOrderInfoCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getPayOrderInfoCountByBusinessId", method = RequestMethod.POST)
    public Long getPayOrderInfoCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return orderService.getPayOrderInfoCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getSendOrderInfoCountByBusinessId", method = RequestMethod.POST)
    public Long getSendOrderInfoCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return orderService.getSendOrderInfoCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderSumCountByBusinessId",method = RequestMethod.POST)
    public Long getOrderSumCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return orderService.getOrderSumCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/insertOrderInfo", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public void insertOrderInfo(@RequestParam(value = "orderId", required = false) String orderId,
                                @RequestParam(value = "userAddress", required = false) String userAddress,
                                @RequestParam(value = "userId", required = false) String userId,
                                @RequestParam(value = "userPhone", required = false) String userPhone,
                                @RequestParam(value = "businessId", required = false) String businessId,
                                @RequestParam(value = "bookId", required = false) String bookId,
                                @RequestParam(value = "bookName", required = false) String bookName,
                                @RequestParam(value = "bookImagePath", required = false) String bookImagePath,
                                @RequestParam(value = "bookNumber", required = false) String bookNumber,
                                @RequestParam(value = "totalPrice", required = false) String totalPrice) {

        orderService.insertOrderInfo(orderId, userAddress, Integer.valueOf(userId), userPhone, Integer.valueOf(businessId), Integer.valueOf(bookId), bookName, bookImagePath, Integer.valueOf(bookNumber), Double.valueOf(totalPrice));
    }

    @ResponseBody
    @RequestMapping(value = "/updateOrderInfo", method = RequestMethod.POST)
    public void updateOrderInfo(@RequestParam(value = "orderId", required = false) String orderId,
                                @RequestParam(value = "userAddress", required = false) String userAddress) {
        orderService.updateOrderInfo(orderId, userAddress);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOrderInfoByOrderId", method = RequestMethod.POST)
    public void deleteOrderInfoByOrderId(@RequestParam(value = "orderId", required = false) String orderId,
                                         @RequestParam(value = "orderInfo", required = false) String orderInfo) {
        orderService.deleteOrderInfoByOrderId(orderId,orderInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/cancelOrderInfoByOrderId", method = RequestMethod.POST)
    public void cancelOrderInfoByOrderId(@RequestParam(value = "orderId", required = false) String orderId,
                                         @RequestParam(value = "orderInfo", required = false) String orderInfo) {
        orderService.cancelOrderInfoByOrderId(orderId,orderInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserAddressByOrderId", method = RequestMethod.POST)
    public void updateUserAddressByOrderId(@RequestParam(value = "orderId", required = false) String orderId,
                                           @RequestParam(value = "userAddress", required = false) String userAddress){
        orderService.updateUserAddressByOrderId(orderId,userAddress);
    }

    @ResponseBody
    @RequestMapping(value = "/payOrderInfoByOrderId", method = RequestMethod.POST)
    public void payOrderInfoByOrderId(@RequestParam(value = "orderId", required = false) String orderId){
        orderService.payOrderInfoByOrderId(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/checkOrderInfoByOrderId", method = RequestMethod.POST)
    public void checkOrderInfoByOrderId(@RequestParam(value = "orderId", required = false) String orderId){
        orderService.checkOrderInfoByOrderId(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/getCustomerCountByBusinessId",method = RequestMethod.POST)
    public Integer getCustomerCountByBusinessId(@RequestParam(value = "businessId",required = false) Integer businessId){
        return orderService.getCustomerCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getPriceCountByBusinessId", method = RequestMethod.POST)
    public Long getPriceCountByBusinessId(@RequestParam(value = "businessId",required = false) Integer businessId){
        return orderService.getPriceCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/shipByOrderId", method = RequestMethod.POST)
    public void shipByOrderId(@RequestParam(value = "orderId",required = false) String orderId){
        orderService.shipByOrderId(orderId);
    }
}

