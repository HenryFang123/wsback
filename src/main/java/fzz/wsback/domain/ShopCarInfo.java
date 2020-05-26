package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户购物信息
 */
@Data
public class ShopCarInfo {
    private Integer shopCarId;
    private Integer userId;
    private Integer businessId;
    private Integer bookId;
    private Integer bookNumber;
}
