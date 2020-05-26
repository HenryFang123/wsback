package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 订单信息
 */
@Data
public class OrderInfo {
    private String createTime;
    private String orderId;
    private Integer orderState;
    private String orderInfo;
    private String userAddress;
    private Integer userId;
    private String userPhone;
    private Integer businessId;
    private Integer bookId;
    private String bookName;
    private String bookImagePath;
    private Integer bookNumber;
    private Double totalPrice;
}
