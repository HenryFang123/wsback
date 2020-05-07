package fzz.wsback.service;

import fzz.wsback.domain.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository("orderService")
public interface OrderService {
    List<OrderInfo> getOrderInfo(Integer businessId, Integer firstIndex, Integer pageSize);

    void deleteOrder(Integer orderId);

    Long getOrderCount(Integer businessId);

    void updateOrder(Integer orderId, String userAddress, String userPhone);

    List<OrderInfo> getOneOrder(Integer orderId);

    void addOrder(Integer orderId,
                  String userAddress,
                  Integer userId,
                  String userPhone,
                  Integer businessId,
                  Integer bookId,
                  String bookName,
                  String bookImagePath,
                  Integer bookNumber,
                  Double totalPrice);

    List<OrderInfo> getOrdersByUserId(Integer userId);
}
