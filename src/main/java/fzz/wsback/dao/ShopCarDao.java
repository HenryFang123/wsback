package fzz.wsback.dao;

import fzz.wsback.domain.ShopCarInfo;
import javafx.scene.chart.ValueAxis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 购物车操作 DAO 层
 */
@Repository(value = "ShopCarDao")
public interface ShopCarDao {
    /**
     * 通过用户 ID获取购物车信息
     *
     * @param userId 用户 ID
     * @return List ShopCarInfo 实体类对象列表
     */
    List<ShopCarInfo> getShopCarInfoListByUserId(@Param("userId") Integer userId);

    /**
     * 新增购物车信息
     *
     * @param userId 用户 ID
     * @param businessId 店铺 ID
     * @param bookId 书籍 ID
     * @param bookNumber 书籍数量
     */
    void insertShopCarInfo(@Param("userId") Integer userId,
                           @Param("businessId") Integer businessId,
                           @Param("bookId") Integer bookId,
                           @Param("bookNumber") Integer bookNumber);

    /**
     * 更新购物车中书籍数量（主增加）
     *
     * @param shopCarId 购物车 ID
     * @param bookNumber 购物车中书籍数量
     */
    void updateShopCarInfoBookNumberAdd(@Param("shopCarId") Integer shopCarId,
                                        @Param("bookNumber") Integer bookNumber);

    /**
     * 更新购物车中书籍数量（主改变）
     *
     * @param shopCarId 购物车 ID
     * @param bookNumber 购物车中书籍数量
     */
    void updateShopCarInfoBookNumberChange(@Param("shopCarId") Integer shopCarId,
                                           @Param("bookNumber") Integer bookNumber);

    /**
     * 通过购物车 ID 删除购物车信息
     *
     * @param shopCarId 购物车 ID
     */
    void deleteShopCarInfoByShopCarId(@Param("shopCarId") Integer shopCarId);

}
