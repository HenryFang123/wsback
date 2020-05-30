package fzz.wsback.controller;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.ShopCarInfo;
import fzz.wsback.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 购物车操作控制层
 */
@Controller
@RequestMapping(value = "/shopCar")
public class ShopCarController {
    private final ShopCarService shopCarService;

    @Autowired
    public ShopCarController(ShopCarService shopCarService) {
        this.shopCarService = shopCarService;
    }

    @ResponseBody
    @RequestMapping(value = "/getShopCarListInfoByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONArray getShopCarListInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return shopCarService.getShopCarListInfoByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/insertShopCarInfo", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public void insertShopCarInfo(ShopCarInfo shopCarInfo) {
        shopCarService.insertShopCarInfo(shopCarInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/updateShopCarInfoBookNumberAdd", method = RequestMethod.POST)
    public void updateShopCarInfoBookNumberAdd(@RequestParam(value = "shopCarId", required = false) String shopCarId,
                                               @RequestParam(value = "bookNumber", required = false) String bookNumber) {
        shopCarService.updateShopCarInfoBookNumberAdd(Integer.valueOf(shopCarId), Integer.valueOf(bookNumber));
    }

    @ResponseBody
    @RequestMapping(value = "/updateShopCarInfoBookNumberChange", method = RequestMethod.POST)
    public void updateShopCarInfoBookNumberChange(@RequestParam(value = "shopCarId", required = false) String shopCarId,
                                                  @RequestParam(value = "bookNumber", required = false) String bookNumber) {
        shopCarService.updateShopCarInfoBookNumberChange(Integer.valueOf(shopCarId), Integer.valueOf(bookNumber));
    }

    @ResponseBody
    @RequestMapping(value = "/deleteShopCarInfoByShopCarId", method = RequestMethod.POST)
    public void deleteShopCarInfoByShopCarId(@RequestParam(value = "shopCarId", required = false) Integer shopCarId) {
        shopCarService.deleteShopCarInfoByShopCarId(shopCarId);
    }
}
