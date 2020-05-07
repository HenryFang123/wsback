package fzz.wsback.controller;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.ShopCarInfo;
import fzz.wsback.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author NE
 */
@Controller
@RequestMapping("/shopCar")
public class ShopCarController {

    private final ShopCarService shopCarService;

    @Autowired
    public ShopCarController(ShopCarService shopCarService) {
        this.shopCarService = shopCarService;
    }

    @ResponseBody
    @RequestMapping(value = "/addItemToShopCar")
    public String addItemToShopCar(ShopCarInfo shopCarInfo, Model model) {
        Integer addShopCarCode = shopCarService.addItemToShopCar(shopCarInfo);

        if (addShopCarCode == 0) {
            // 失败标志
            return "{\"resultCode\":\"0\"}";
        } else {
            // 成功标志
            return "{\"resultCode\":\"1\"}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getShopCarInfoByUserId", produces = {"application/json;charset=UTF-8"})
    public String getShopCarInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId,
                                         Model model) {
        JSONArray jsonArray = shopCarService.getShopCarInfoByUserId(userId);

        if (jsonArray == null) {
            // 失败标志
            return "{\"resultCode\":\"0\"}";
        } else {
            return jsonArray.toString();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateBookNumber", produces = {"application/json;charset=UTF-8"})
    public void updateBookNumber(@RequestParam(value = "shopCarId", required = false) String shopCarId,
                                 @RequestParam(value = "bookNumber", required = false) String bookNumber) {
        shopCarService.updateBookNumber(Integer.valueOf(shopCarId), Integer.valueOf(bookNumber));
    }

    @ResponseBody
    @RequestMapping(value = "/updateBookNumber2", produces = {"application/json;charset=UTF-8"})
    public void updateBookNumber2(@RequestParam(value = "shopCarId", required = false) String shopCarId,
                                  @RequestParam(value = "bookNumber", required = false) String bookNumber) {
        shopCarService.updateBookNumber2(Integer.valueOf(shopCarId), Integer.valueOf(bookNumber));
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBookByShopCarId")
    public void deleteBookByBookId(Integer shopCarId, Model model) {
        shopCarService.deleteBookByShopCarId(shopCarId);
    }


}
