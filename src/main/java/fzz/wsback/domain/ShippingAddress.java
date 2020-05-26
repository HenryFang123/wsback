package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZJH
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户收货地址信息
 */
@Data
public class ShippingAddress {
    private Integer id;
    private String userPhone;
    private String consignee;
    private String province;
    private String city;
    private String region;
    private String address;
    private String postPhone;
    private Integer defaultAddress;
}
