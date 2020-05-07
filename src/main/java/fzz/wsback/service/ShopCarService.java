package fzz.wsback.service;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.ShopCarInfo;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository("shopCarService")
public interface ShopCarService {

    /**
     * add shop car item to mysql.
     *
     * @param shopCarInfo
     * @return resultCode
     */
    Integer addItemToShopCar(ShopCarInfo shopCarInfo);

    /**
     * get shop car item from mysql by user id.
     *
     * @param userId
     * @return JSONArray
     */
    JSONArray getShopCarInfoByUserId(Integer userId);

    /**
     * update book number by shop car id.
     *
     * @param shopCarId
     * @param bookNumber
     */
    void updateBookNumber(Integer shopCarId, Integer bookNumber);

    /**
     * update book number by shop car id.
     *
     * @param shopCarId
     * @param bookNumber
     */
    void updateBookNumber2(Integer shopCarId, Integer bookNumber);

    /**
     * delete book  by shop car id.
     *
     * @param shopCarId
     */
    void deleteBookByShopCarId(Integer shopCarId);
}
