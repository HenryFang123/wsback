package fzz.wsback.controller;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.ShippingAddress;
import fzz.wsback.service.ShippingAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ZJH
 */
@Controller
@RequestMapping(value = "/shippingAddress")
public class ShippingAddressController {
    private final ShippingAddressService shippingAddressService;

    @Autowired
    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    @ResponseBody
    @RequestMapping(value = "/getShippingAddressListByUserPhone", method = RequestMethod.POST)
    public List<ShippingAddress> getShippingAddressListByUserPhone(@RequestParam(value = "userPhone", required = false) String userPhone){
        return shippingAddressService.getShippingAddressListByUserPhone(userPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/getShippingAddressListByUserPhoneAndHandle", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONArray getShippingAddressListByUserPhoneAndHandle(@RequestParam(value = "userPhone", required = false) String userPhone){
        return shippingAddressService.getShippingAddressListByUserPhoneAndHandle(userPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/updateShippingAddress", method = RequestMethod.POST)
    public void updateShippingAddress(@RequestParam(value = "id", required = false) Integer id,
                                      @RequestParam(value = "userPhone", required = false) String userPhone,
                                      @RequestParam(value = "consignee", required = false) String consignee,
                                      @RequestParam(value = "province", required = false) String province,
                                      @RequestParam(value = "city", required = false) String city,
                                      @RequestParam(value = "region",required = false) String region,
                                      @RequestParam(value = "address", required = false) String address,
                                      @RequestParam(value = "postPhone", required = false) String postPhone){
        shippingAddressService.updateShippingAddress(id, userPhone, consignee, province, city, region, address, postPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/insertAddress", method = RequestMethod.POST)
    public void insertAddress(@RequestParam(value = "userPhone", required = false) String userPhone,
                              @RequestParam(value = "consignee", required = false) String consignee,
                              @RequestParam(value = "province", required = false) String province,
                              @RequestParam(value = "city", required = false) String city,
                              @RequestParam(value = "region", required = false) String region,
                              @RequestParam(value = "address", required = false) String address,
                              @RequestParam(value = "postPhone", required = false) String postPhone){
        shippingAddressService.insertAddress(userPhone,consignee,province,city,region,address,postPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteShippingAddress", method = RequestMethod.POST)
    public void deleteShippingAddress(@RequestParam(value = "id", required = false) Integer id,
                                      @RequestParam(value = "userPhone", required = false) String userPhone){
        shippingAddressService.deleteShippingAddress(id, userPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/setDefaultAddress" , method = RequestMethod.POST)
    public void setDefaultAddress(@RequestParam(value = "userPhone",required = false)String userPhone,
                                  @RequestParam(value = "id",required = false) Integer id){
        shippingAddressService.setDefaultAddress(userPhone,id);
    }
}
