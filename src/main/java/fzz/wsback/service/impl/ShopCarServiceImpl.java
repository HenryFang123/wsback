package fzz.wsback.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.dao.BookDao;
import fzz.wsback.dao.ShopCarDao;
import fzz.wsback.domain.BookInfo;
import fzz.wsback.domain.ShopCarInfo;
import fzz.wsback.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 购物车操作 SERVICE 层实现
 */
@Service(value = "shopCarService")
public class ShopCarServiceImpl implements ShopCarService {
    private final ShopCarDao shopCarDao;
    private final BookDao bookDao;

    @Autowired
    public ShopCarServiceImpl(ShopCarDao shopCarDao, BookDao bookDao) {
        this.shopCarDao = shopCarDao;
        this.bookDao = bookDao;
    }

    @Override
    public JSONArray getShopCarListInfoByUserId(Integer userId) {
        List<ShopCarInfo> shopCarInfos = shopCarDao.getShopCarInfoListByUserId(userId);
        BookInfo bookInfo = new BookInfo();
        JSONArray jsonArray = new JSONArray();
        Integer id = 1;
        for (ShopCarInfo shopCarInfo : shopCarInfos) {
            bookInfo = bookDao.getBookInfoById(shopCarInfo.getBookId());
            JSONObject jsonObject = new JSONObject();

            // 购物车显示ID
            jsonObject.put("id", id);
            // 购物车ID
            jsonObject.put("shop_car_id", shopCarInfo.getShopCarId());
            // 购物车书籍ID
            jsonObject.put("book_id", shopCarInfo.getBookId());
            // 购物车书籍图片路径
            jsonObject.put("book_image_path", bookInfo.getBookImagePath());
            // 购物车书籍名
            jsonObject.put("book_name", bookInfo.getBookName());
            // 购物车书籍店铺ID
            jsonObject.put("business_id", bookInfo.getBusinessId());
            // 购物车书籍价格
            jsonObject.put("book_price", bookInfo.getBookPrice());
            // 购物车书籍数量
            jsonObject.put("book_number", shopCarInfo.getBookNumber());

            jsonArray.add(jsonObject);
            id ++;
        }
        return jsonArray;
    }

    @Override
    public void insertShopCarInfo(ShopCarInfo shopCarInfo) {
        shopCarDao.insertShopCarInfo(shopCarInfo.getUserId(), shopCarInfo.getBusinessId(), shopCarInfo.getBookId(), shopCarInfo.getBookNumber());
    }

    @Override
    public void updateShopCarInfoBookNumberAdd(Integer shopCarId, Integer bookNumber) {
        shopCarDao.updateShopCarInfoBookNumberAdd(shopCarId, bookNumber);
    }

    @Override
    public void updateShopCarInfoBookNumberChange(Integer shopCarId, Integer bookNumber) {
        shopCarDao.updateShopCarInfoBookNumberChange(shopCarId, bookNumber);
    }

    @Override
    public void deleteShopCarInfoByShopCarId(Integer shopCarId) {
        shopCarDao.deleteShopCarInfoByShopCarId(shopCarId);
    }
}
