package fzz.wsback.controller;

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
    @RequestMapping(value = "/getShippingAddressByUserPhone", method = RequestMethod.POST)
    public List<ShippingAddress> getShippingAddressByUserPhone(@RequestParam(value = "userPhone", required = false) String userPhone){
        return shippingAddressService.getShippingAddressByUserPhone(userPhone);
    }

    @ResponseBody
    @RequestMapping(value = "/updateShippingAddress", method = RequestMethod.POST)
    public void updateShippingAddress(@RequestParam(value = "id", required = false) Integer id,
                                      @RequestParam(value = "userPhone", required = false) String userPhone,
                                      @RequestParam(value = "consignee", required = false) String consignee,
                                      @RequestParam(value = "province", required = false) String province,
                                      @RequestParam(value = "city", required = false) String city,
                                      @RequestParam(value = "address", required = false) String address,
                                      @RequestParam(value = "postPhone", required = false) String postPhone){
        shippingAddressService.updateShippingAddress(id, userPhone, consignee, province, city, address, postPhone);
    }
}