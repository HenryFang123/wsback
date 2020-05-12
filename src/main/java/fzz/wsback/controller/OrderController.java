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
 * @author fh
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

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
    @RequestMapping(value = "/getOrderInfoListByBusinessId", method = RequestMethod.POST)
    public List<OrderInfo> getOrderInfoListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                        @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return orderService.getOrderInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfoCountByBusinessId", method = RequestMethod.POST)
    public Long getOrderInfoCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return orderService.getOrderInfoCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderInfoCountByUserId", method = RequestMethod.POST)
    public Long getOrderInfoCountByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return orderService.getOrderInfoCountByUserId(userId);
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
                                @RequestParam(value = "userAddress", required = false) String userAddress,
                                @RequestParam(value = "userPhone", required = false) String userPhone) {
        orderService.updateOrderInfo(orderId, userAddress, userPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOrderInfoByOrderId", method = RequestMethod.POST)
    public void deleteOrderInfoByOrderId(@RequestParam(value = "orderId", required = false) String orderId) {
        orderService.deleteOrderInfoByOrderId(orderId);
    }
}
