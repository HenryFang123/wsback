package fzz.wsback.dao;

import fzz.wsback.domain.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FH
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 订单操作 DAO 层
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
     * 通过用户 ID 获取用户所有未付款订单信息
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoListByUserId(@Param("userId") Integer userId);

    /**
     * 通过用户 ID 获取已付款但未发货订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getNotDeliverOrderInfoByUserId(@Param("userId") Integer userId);

    /**
     * 通过用户 ID 获取已发货但未签收订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getNotSignOrderInfoByUserId(@Param("userId") Integer userId);

    /**
     * 通过用户 ID 获取已提交退货的订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getCancelOrderInfoByUserId(@Param("userId") Integer userId);

    /**
     * 通过用户 ID 获取已取消的订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getDoneOrderInfoByUserId(@Param("userId") Integer userId);

    /**
     * 通过订单 ID 确认订单签收完成
     *
     * @param orderId 订单 ID
     */
    void checkOrderInfoByOrderId(@Param("orderId") String orderId);

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
     * 通过店铺 ID 获取店铺订单2信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize 分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getPayOrderInfoListByBusinessId(@Param("businessId") Integer businessId,
                                                 @Param("firstIndex") Integer firstIndex,
                                                 @Param("pageSize") Integer pageSize);

    /**
     * 通过店铺 ID 获取店铺订单3信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize 分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getSendOrderInfoListByBusinessId(@Param("businessId") Integer businessId,
                                                    @Param("firstIndex") Integer firstIndex,
                                                    @Param("pageSize") Integer pageSize);

    /**
     * 通过店铺 ID 获取店铺订单4信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize 分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getReturnOrderInfoListByBusinessId(@Param("businessId") Integer businessId,
                                                     @Param("firstIndex") Integer firstIndex,
                                                     @Param("pageSize") Integer pageSize);

    /**
     * 通过店铺 ID 获取当前店铺退货数量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getReturnOrderInfoCountByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺状态总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderInfoCountByBusinessId(@Param("businessId") Integer businessId);


    /**
     * 通过店铺 ID 获取当前店铺状态2总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getPayOrderInfoCountByBusinessId(@Param("businessId") Integer businessId);
    /**
     * 通过店铺 ID 获取当前店铺状态3总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getSendOrderInfoCountByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺状态2、3总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderSumCountByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺总顾客数
     *
     * @param businessId 店铺 ID
     * @return Integer 顾客数
     */
    Integer getCustomerCountByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺总收入
     *
     * @param businessId 店铺 ID
     * @return Long 总收入
     */
    Long getPriceCountByBusinessId(@Param("businessId") Integer businessId);
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
     */
    void updateOrderInfo(@Param("orderId") String orderId,
                         @Param("userAddress") String userAddress);

    /**
     * 通过订单 ID 删除订单
     *
     * @param orderId 订单 ID
     */
    void deleteOrderInfoByOrderId(@Param("orderId") String orderId,
                                  @Param("orderInfo") String orderInfo);

    /**
     * 通过订单 ID 退货
     *
     * @param orderId 订单 ID
     */
    void cancelOrderInfoByOrderId(@Param("orderId") String orderId,
                                  @Param("orderInfo") String orderInfo);

    /**
     * 通过订单 ID 修改用户收货物信息
     *
     * @param orderId 订单 ID
     * @param userAddress 收货地址
     */
    void updateUserAddressByOrderId(@Param("orderId") String orderId,
                                    @Param("userAddress") String userAddress);

    /**
     * 通过订单 ID 完成付款
     *
     * @param orderId 订单 ID
     */
    void payOrderInfoByOrderId(@Param("orderId") String orderId);

    /**
     * 通过订单 ID 完成发货
     *
     * @param orderId 订单 ID
     */
    void shipByOrderId(@Param("orderId") String orderId);
}
