package fzz.wsback.dao;

import fzz.wsback.domain.ShopCarInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository("ShopCarDao")
public interface ShopCarDao {

    /**
     * add data to mysql from front frame.
     *
     * @param userId
     * @param businessId
     * @param bookId
     * @param bookNumber
     */
    void addItemToShopCar(@Param("userId") Integer userId,
                          @Param("businessId") Integer businessId,
                          @Param("bookId") Integer bookId,
                          @Param("bookNumber") Integer bookNumber);

    /**
     * get data from mysql by user id.
     *
     * @param userId
     * @return ShopCarInfo
     */
    List<ShopCarInfo> getShopCarInfoByUserId(@Param("userId") Integer userId);

    /**
     * update data to mysql with book number.
     *
     * @param shopCarId
     * @param bookNumber
     */
    void updateBookNumber(@Param("shopCarId") Integer shopCarId,
                          @Param("bookNumber") Integer bookNumber);

    /**
     * update data to mysql with book number.
     *
     * @param shopCarId
     * @param bookNumber
     */
    void updateBookNumber2(@Param("shopCarId") Integer shopCarId,
                           @Param("bookNumber") Integer bookNumber);

    /**
     * delete data from mysql by shop car id.
     *
     * @param shopCarId
     */
    void deleteBookByShopCarId(@Param("shopCarId") Integer shopCarId);
}
