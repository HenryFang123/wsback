package fzz.wsback.service;

import fzz.wsback.domain.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FH
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 订单操作 SERVICE 层
 */
@Repository(value = "OrderService")
public interface OrderService {
    /**
     * 通过订单 ID 获取订单信息
     *
     * @param orderId 订单 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoByOrderId(String orderId);

    /**
     * 通过用户 ID 获取用户所有未付款订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoListByUserId(Integer userId);

    /**
     * 通过用户 ID 获取已付款但未发货订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getNotDeliverOrderInfoByUserId(Integer userId);

    /**
     * 通过用户 ID 获取已发货但未签收订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getNotSignOrderInfoByUserId(Integer userId);

    /**
     * 通过用户 ID 获取已提交退货的订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getCancelOrderInfoByUserId(Integer userId);

    /**
     * 通过用户 ID 获取已取消的订单信息
     *
     * @param userId 用户 ID
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getDoneOrderInfoByUserId(Integer userId);

    /**
     * 通过订单ID确认订单签收完成
     *
     * @param orderId
     */
    void checkOrderInfoByOrderId(String orderId);

    /**
     * 通过店铺 ID 获取店铺订单信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize   分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoListByBusinessId(Integer businessId,
                                                 Integer firstIndex,
                                                 Integer pageSize);

    /**
     * 通过店铺 ID 获取店铺订单2信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize   分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getPayOrderInfoListByBusinessId(Integer businessId,
                                                    Integer firstIndex,
                                                    Integer pageSize);

    /**
     * 通过店铺 ID 获取店铺订单3信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize   分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getSendOrderInfoListByBusinessId(Integer businessId,
                                                    Integer firstIndex,
                                                    Integer pageSize);

    /**
     * 通过店铺 ID 获取店铺订单4信息
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize   分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getReturnOrderInfoListByBusinessId(Integer businessId,
                                                     Integer firstIndex,
                                                     Integer pageSize);

    /**
     * 通过店铺 ID 获取当前店铺退货数量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getReturnOrderInfoCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderInfoCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺订单状态2数量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getPayOrderInfoCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺订单状态3数量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getSendOrderInfoCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderSumCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺总顾客数
     *
     * @param businessId 店铺 ID
     * @return Long 顾客数
     */
    Integer getCustomerCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 获取当前店铺总收入
     *
     * @param businessId 店铺 ID
     * @return Long 总收入
     */
    Long getPriceCountByBusinessId(Integer businessId);

    /**
     * 新建订单
     *
     * @param orderId       订单 ID
     * @param userAddress   订单收货地址
     * @param userId        用户 ID
     * @param userPhone     用户手机号
     * @param businessId    店铺 ID
     * @param bookId        书籍 ID
     * @param bookName      书籍名称
     * @param bookImagePath 书籍图片路径
     * @param bookNumber    书籍数量
     * @param totalPrice    订单总价
     */
    void insertOrderInfo(String orderId,
                         String userAddress,
                         Integer userId,
                         String userPhone,
                         Integer businessId,
                         Integer bookId,
                         String bookName,
                         String bookImagePath,
                         Integer bookNumber,
                         Double totalPrice);

    /**
     * 更新订单信息
     *
     * @param orderId     订单 ID
     * @param userAddress 用户收货地址
     */
    void updateOrderInfo(String orderId,
                         String userAddress);

    /**
     * 通过订单 ID 删除订单
     *
     * @param orderId 订单 ID
     */
    void deleteOrderInfoByOrderId(String orderId, String orderInfo);

    /**
     * 通过订单 ID 退货
     *
     * @param orderId 订单 ID
     */
    void cancelOrderInfoByOrderId(String orderId, String orderInfo);


    /**
     * 通过订单ID修改用户收货信息
     *
     * @param orderId     订单ID
     * @param userAddress 收货地址
     */
    void updateUserAddressByOrderId(String orderId, String userAddress);


    /**
     * 通过订单ID完成付款
     *
     * @param orderId 订单ID
     */
    void payOrderInfoByOrderId(String orderId);

    /**
     * 通过订单ID完成商品发货
     *
     * @param orderId 订单ID
     */
    void shipByOrderId(String orderId);

}
