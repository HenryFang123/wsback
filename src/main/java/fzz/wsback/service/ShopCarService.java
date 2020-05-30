package fzz.wsback.service;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.ShopCarInfo;
import org.springframework.stereotype.Repository;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 购物车操作 SERVICE 层
 */
@Repository(value = "ShopCarService")
public interface ShopCarService {

    /**
     * 通过用户 ID 获取该用户所有购物车信息
     *
     * @param userId 用户 ID
     * @return List ShopCarInfo 实体类对象列表
     */
    JSONArray getShopCarListInfoByUserId(Integer userId);

    /**
     * 新增购物车信息
     *
     * @param shopCarInfo 实体类对象
     */
    void insertShopCarInfo(ShopCarInfo shopCarInfo);

    /**
     * 更新购物车中书籍数量（主增加）
     *
     * @param shopCarId 购物车 ID
     * @param bookNumber 购物车中书籍数量
     */
    void updateShopCarInfoBookNumberAdd(Integer shopCarId,
                                        Integer bookNumber);

    /**
     * 更新购物车中书籍数量（主改变）
     *
     * @param shopCarId 购物车 ID
     * @param bookNumber 购物车中书籍数量
     */
    void updateShopCarInfoBookNumberChange(Integer shopCarId,
                                           Integer bookNumber);

    /**
     * 通过购物车 ID 删除购物车信息
     *
     * @param shopCarId 购物车 ID
     */
    void deleteShopCarInfoByShopCarId(Integer shopCarId);
}
