package fzz.wsback.dao;

import fzz.wsback.domain.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fh
 */
@Repository(value = "OrderDao")
public interface OrderDao {
    /**
     * 通过订单 ID 获取订单信息
     *
     * @param orderId 订单 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoByOrderId(@Param("orderId") String orderId);

    /**
     * 通过用户 ID 获取用户所有订单信息
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoListByUserId(@Param("userId") Integer userId);

    /**
     * 通过店铺 ID 获取店铺订单信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize 分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoListByBusinessId(@Param("businessId") Integer businessId,
                                                 @Param("firstIndex") Integer firstIndex,
                                                 @Param("pageSize") Integer pageSize);

    /**
     * 通过店铺 ID 获取当前店铺总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderInfoCountByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过用户 ID 获取当前用户有效总订单量
     *
     * @param userId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderInfoCountByUserId(@Param("userId") Integer userId);

    /**
     * 新建订单
     *
     * @param orderId 订单 ID
     * @param userAddress 订单收货地址
     * @param userId 用户 ID
     * @param userPhone 用户手机号
     * @param businessId 店铺 ID
     * @param bookId 书籍 ID
     * @param bookName 书籍名称
     * @param bookImagePath 书籍图片路径
     * @param bookNumber 书籍数量
     * @param totalPrice 订单总价
     */
    void insertOrderInfo(@Param("orderId") String orderId,
                         @Param("userAddress") String userAddress,
                         @Param("userId") Integer userId,
                         @Param("userPhone") String userPhone,
                         @Param("businessId") Integer businessId,
                         @Param("bookId") Integer bookId,
                         @Param("bookName") String bookName,
                         @Param("bookImagePath") String bookImagePath,
                         @Param("bookNumber") Integer bookNumber,
                         @Param("totalPrice") Double totalPrice);

    /**
     * 更新订单信息
     *
     * @param orderId 订单 ID
     * @param userAddress 用户收货地址
     * @param userPhone 用户手机号
     */
    void updateOrderInfo(@Param("orderId") String orderId,
                         @Param("userAddress") String userAddress,
                         @Param("userPhone") String userPhone);

    /**
     * 通过订单 ID 删除订单
     *
     * @param orderId 订单 ID
     */
    void deleteOrderInfoByOrderId(@Param("orderId") String orderId);
}
