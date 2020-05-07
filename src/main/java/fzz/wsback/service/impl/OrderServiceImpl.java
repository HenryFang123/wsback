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
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public List<OrderInfo> getOrderInfo(Integer businessId, Integer firstIndex, Integer pageSize) {
        return orderDao.getOrderInfo(businessId, firstIndex, pageSize);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderDao.deleteOrder(orderId);
    }

    @Override
    public Long getOrderCount(Integer businessId) {
        return orderDao.getOrderCount(businessId);
    }

    @Override
    public void updateOrder(Integer orderId, String userAddress, String userPhone) {
        orderDao.updateOrder(orderId, userAddress, userPhone);
    }

    @Override
    public List<OrderInfo> getOneOrder(Integer orderId) {
        return orderDao.getOneOrder(orderId);
    }

    @Override
    public void addOrder(Integer orderId,
                         String userAddress,
                         Integer userId,
                         String userPhone,
                         Integer businessId,
                         Integer bookId,
                         String bookName,
                         String bookImagePath,
                         Integer bookNumber,
                         Double totalPrice) {
        orderDao.addOrder(orderId, userAddress, userId, userPhone, businessId, bookId, bookName, bookImagePath, bookNumber, totalPrice);
    }

    @Override
    public List<OrderInfo> getOrdersByUserId(Integer userId) {
        return orderDao.getOrdersByUserId(userId);
    }
}
