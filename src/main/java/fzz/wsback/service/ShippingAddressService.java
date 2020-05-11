package fzz.wsback.service;

import fzz.wsback.domain.ShippingAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZJH
 */
@Repository(value = "shippingAddressService")
public interface ShippingAddressService {
    /**
     * 通过用户手机号获取用户收货地址
     *
     * @param userPhone 用户手机号
     * @return List ShippingAddress 实体类对象列表
     */
    List<ShippingAddress> getShippingAddressByUserPhone(String userPhone);

    /**
     * 更新用户收货地址
     *
     * @param id 收货地址 ID
     * @param userPhone 用户手机号
     * @param consignee 收货人
     * @param province 生粉
     * @param city 城市
     * @param address 详细地址
     * @param postPhone 收货人手机号
     */
    void updateShippingAddress(Integer id,
                               String userPhone,
                               String consignee,
                               String province,
                               String city,
                               String address,
                               String postPhone);
}
