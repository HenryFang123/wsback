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
 * @author NE
 */
@Service("shopCarService")
public class ShopCarServiceImpl implements ShopCarService {
    private final ShopCarDao shopCarDao;
    private final BookDao bookDao;

    @Autowired
    public ShopCarServiceImpl(ShopCarDao shopCarDao, BookDao bookDao) {
        this.shopCarDao = shopCarDao;
        this.bookDao = bookDao;
    }

    @Override
    public Integer addItemToShopCar(ShopCarInfo shopCarInfo) {
        try {
            shopCarDao.addItemToShopCar(shopCarInfo.getUserId(), shopCarInfo.getBusinessId(), shopCarInfo.getBookId(), shopCarInfo.getBookNumber());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public JSONArray getShopCarInfoByUserId(Integer userId) {
        List<ShopCarInfo> shopCarInfos = shopCarDao.getShopCarInfoByUserId(userId);
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

            id++;
        }

        return jsonArray;
    }

    @Override
    public void updateBookNumber(Integer shopCarId, Integer bookNumber) {
        shopCarDao.updateBookNumber(shopCarId, bookNumber);
    }

    @Override
    public void updateBookNumber2(Integer shopCarId, Integer bookNumber) {
        shopCarDao.updateBookNumber2(shopCarId, bookNumber);
    }

    @Override
    public void deleteBookByShopCarId(Integer shopCarId) {
        shopCarDao.deleteBookByShopCarId(shopCarId);
    }
}
