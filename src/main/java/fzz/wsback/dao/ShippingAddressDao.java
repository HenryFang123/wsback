package fzz.wsback.dao;

import fzz.wsback.domain.ShippingAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZJH
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户收货地址操作 DAO 层
 */
@Repository(value = "ShippingAddressDao")
public interface ShippingAddressDao {
    /**
     * 通过用户手机号获取用户收货地址
     *
     * @param userPhone 用户手机号
     * @return List ShippingAddress 实体类对象列表
     */
    List<ShippingAddress> getShippingAddressListByUserPhone(@Param("userPhone") String userPhone);

    /**
     * 更新用户收货地址
     *
     * @param id 收货地址 ID
     * @param userPhone 用户手机号
     * @param consignee 收货人
     * @param province 生粉
     * @param city 城市
     * @param region 区域
     * @param address 详细地址
     * @param postPhone 收货人手机号
     */
    void updateShippingAddress(@Param("id") Integer id,
                               @Param("userPhone") String userPhone,
                               @Param("consignee") String consignee,
                               @Param("province") String province,
                               @Param("city") String city,
                               @Param("region") String region,
                               @Param("address") String address,
                               @Param("postPhone") String postPhone);

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
    void insertAddress(@Param("userPhone") String userPhone,
                       @Param("consignee") String consignee,
                       @Param("province") String province,
                       @Param("city") String city,
                       @Param("region") String region,
                       @Param("address") String address,
                       @Param("postPhone") String postPhone);

    /**
     * 删除用户收货地址
     *
     * @param id 收货地址 ID
     * @param userPhone 用户手机号
     */
    void deleteShippingAddress(@Param("id") Integer id,
                               @Param("userPhone") String userPhone);
    /**
     * 设置默认收货地址
     *
     * @param id        收货地址 ID
     * @param userPhone 用户手机号
     */
    void setDefaultAddress(@Param("userPhone") String userPhone,
                           @Param("id") Integer id);
}
