package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.OrderInfo;
import fzz.wsback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author FH
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping(value = "/getOrder")
    public List<OrderInfo> getOrders(@RequestParam(value = "businessId", required = false) Integer businessId,
                                     @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return orderService.getOrderInfo(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrderCount")
    public Long getOrderCount(Integer businessId) {
        return orderService.getOrderCount(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOrder")
    public void deleteOrder(Integer orderId) {
        orderService.deleteOrder(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/updateOrder")
    public void updateOrder(Integer orderId, String userAddress, String userPhone) {
        orderService.updateOrder(orderId, userAddress, userPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/getOneOrder")
    public List<OrderInfo> getOneOrder(Integer orderId) {
        return orderService.getOneOrder(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/addOrder", produces = {"application/json;charset=UTF-8"})
    public String addOrder(@RequestParam(value = "orderId", required = false) String orderId,
                           @RequestParam(value = "userAddress", required = false) String userAddress,
                           @RequestParam(value = "userId", required = false) String userId,
                           @RequestParam(value = "userPhone", required = false) String userPhone,
                           @RequestParam(value = "businessId", required = false) String businessId,
                           @RequestParam(value = "bookId", required = false) String bookId,
                           @RequestParam(value = "bookName", required = false) String bookName,
                           @RequestParam(value = "bookImagePath", required = false) String bookImagePath,
                           @RequestParam(value = "bookNumber", required = false) String bookNumber,
                           @RequestParam(value = "totalPrice", required = false) String totalPrice) {

        orderService.addOrder(Integer.valueOf(orderId),
                userAddress,
                Integer.valueOf(userId),
                userPhone,
                Integer.valueOf(businessId),
                Integer.valueOf(bookId),
                bookName,
                bookImagePath,
                Integer.valueOf(bookNumber),
                Double.valueOf(totalPrice));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resultCode", '1');
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/getOrdersByUserId")
    public List<OrderInfo> getOrdersByUserId(Integer userId) {
        return orderService.getOrdersByUserId(userId);
    }
}
