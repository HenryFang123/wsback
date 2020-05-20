package fzz.wsback.service.impl;

import fzz.wsback.dao.OrderDao;
import fzz.wsback.domain.OrderInfo;
import fzz.wsback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fh
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<OrderInfo> getOrderInfoByOrderId(String orderId) {
        return orderDao.getOrderInfoByOrderId(orderId);
    }

    @Override
    public List<OrderInfo> getOrderInfoListByUserId(Integer userId) {
        return orderDao.getOrderInfoListByUserId(userId);
    }

    @Override
    public List<OrderInfo> getNotDeliverOrderInfoByUserId(Integer userId){
        return orderDao.getNotDeliverOrderInfoByUserId(userId);
    }

    @Override
    public List<OrderInfo> getNotSignOrderInfoByUserId(Integer userId){
        return orderDao.getNotSignOrderInfoByUserId(userId);
    }

    @Override
    public List<OrderInfo> getDoneOrderInfoByUserId(Integer userId){
        return orderDao.getDoneOrderInfoByUserId(userId);
    }

    @Override
    public List<OrderInfo> getOrderInfoListByBusinessId(Integer businessId, Integer firstIndex, Integer pageSize) {
        return orderDao.getOrderInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @Override
    public Long getOrderInfoCountByBusinessId(Integer businessId) {
        return orderDao.getOrderInfoCountByBusinessId(businessId);
    }

    @Override
    public Long getOrderSumCountByBusinessId(Integer businessId) {
        return orderDao.getOrderSumCountByBusinessId(businessId);
    }

    @Override
    public Integer getCustomerCountByBusinessId(Integer businessId) {
        return orderDao.getCustomerCountByBusinessId(businessId);
    }

    @Override
    public Long getPriceCountByBusinessId(Integer businessId) {
        return orderDao.getPriceCountByBusinessId(businessId);
    }

    @Override
    public void insertOrderInfo(String orderId,
                                String userAddress,
                                Integer userId,
                                String userPhone,
                                Integer businessId,
                                Integer bookId,
                                String bookName,
                                String bookImagePath,
                                Integer bookNumber,
                                Double totalPrice) {
        orderDao.insertOrderInfo(orderId, userAddress, userId, userPhone, businessId, bookId, bookName, bookImagePath, bookNumber, totalPrice);
    }

    @Override
    public void updateOrderInfo(String orderId, String userAddress) {
        orderDao.updateOrderInfo(orderId, userAddress);
    }

    @Override
    public void deleteOrderInfoByOrderId(String orderId,String orderInfo) {
        orderDao.deleteOrderInfoByOrderId(orderId,orderInfo);
    }

    @Override
    public void updateUserAddressByOrderId(String orderId,String userAddress){
        orderDao.updateUserAddressByOrderId(orderId,userAddress);
    }

    @Override
    public void payOrderInfoByOrderId(String orderId){
        orderDao.payOrderInfoByOrderId(orderId);
    }

    @Override
    public void shipByOrderId(String orderId) {
        orderDao.shipByOrderId(orderId);
    }

    @Override
    public void checkOrderInfoByOrderId(String orderId){orderDao.checkOrderInfoByOrderId(orderId);}
}
