package fzz.wsback.dao;

import fzz.wsback.domain.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fh
 */
@Repository("OrderDao")
public interface OrderDao {
    List<OrderInfo> getOrderInfo(@Param("businessId") Integer businessId, @Param("firstIndex") Integer firstIndex, @Param("pageSize") Integer pageSize);

    void deleteOrder(@Param("orderId") Integer orderId);

    Long getOrderCount(@Param("businessId") Integer businessId);

    void updateOrder(@Param("orderId") Integer orderId, @Param("userAddress") String userAddress, @Param("userPhone") String userPhone);

    List<OrderInfo> getOneOrder(@Param("orderId") Integer orderId);

    void addOrder(@Param("orderId") Integer orderId,
                  @Param("userAddress") String userAddress,
                  @Param("userId") Integer userId,
                  @Param("userPhone") String userPhone,
                  @Param("businessId") Integer businessId,
                  @Param("bookId") Integer bookId,
                  @Param("bookName") String bookName,
                  @Param("bookImagePath") String bookImagePath,
                  @Param("bookNumber") Integer bookNumber,
                  @Param("totalPrice") Double totalPrice);

    List<OrderInfo> getOrdersByUserId(@Param("userId") Integer userId);
}
