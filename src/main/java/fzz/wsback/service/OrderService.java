package fzz.wsback.service;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import fzz.wsback.domain.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository(value = "orderService")
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
     * @param pageSize 分页大小
     * @return List OrderInfo 实体类对象列表
     */
    List<OrderInfo> getOrderInfoListByBusinessId(Integer businessId,
                                                 Integer firstIndex,
                                                 Integer pageSize);

    /**
     * 通过店铺 ID 获取当前店铺总订单量
     *
     * @param businessId 店铺 ID
     * @return Long 订单总数
     */
    Long getOrderInfoCountByBusinessId(Integer businessId);

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
     * @param orderId 订单 ID
     * @param userAddress 用户收货地址
     * @param userPhone 用户手机号
     */
    void updateOrderInfo(String orderId,
                         String userAddress,
                         String userPhone);

    /**
     * 通过订单 ID 删除订单
     *
     * @param orderId 订单 ID
     */
    void deleteOrderInfoByOrderId(String orderId, String orderInfo);


    /**
     * 通过订单ID修改用户收货信息
     *
     * @param orderId
     * @param userAddress
     */
    void updateUserAddressByOrderId(String orderId,String userAddress);


    /**
     * 通过订单ID完成付款
     *
     * @param orderId
     */
    void payOrderInfoByOrderId(String orderId);

}
