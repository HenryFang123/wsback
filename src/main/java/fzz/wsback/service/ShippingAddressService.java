package fzz.wsback.service;

import com.alibaba.fastjson.JSONArray;
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
    List<ShippingAddress> getShippingAddressListByUserPhone(String userPhone);

    /**
     * 通过用户手机号获取用户收货地址并处理
     *
     * @param userPhone 用户手机号
     * @return List ShippingAddress 实体类对象列表
     */
    JSONArray getShippingAddressListByUserPhoneAndHandle(String userPhone);

    /**
     * 更新用户收货地址
     *
     * @param id 收货地址 ID
     * @param userPhone 用户手机号
     * @param consignee 收货人
     * @param province 省份
     * @param city 城市
     * @param address 详细地址
     * @param postPhone 收货人手机号
     */
    void updateShippingAddress(Integer id,
                               String userPhone,
                               String consignee,
                               String province,
                               String city,
                               String region,
                               String address,
                               String postPhone);
    /**
     * 增加用户收货地址
     *
     * @param userPhone 用户手机号
     * @param consignee 收货人
     * @param province 省份
     * @param city 城市
     * @param region 区
     * @param address 详细地址
     * @param postPhone 收货人手机号
     */
    void insertAddress(String userPhone,
                       String consignee,
                       String province,
                       String city,
                       String region,
                       String address,
                       String postPhone);

    /**
     * 删除用户收货地址
     *
     * @param id        收货地址 ID
     * @param userPhone 用户手机号
     */
    void deleteShippingAddress(Integer id,
                               String userPhone);
    /**
     * 设置默认收货地址
     *
     * @param id        收货地址 ID
     * @param userPhone 用户手机号
     */
    void setDefaultAddress(String userPhone,
                           Integer id);
}
