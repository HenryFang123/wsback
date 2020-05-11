package fzz.wsback.service.impl;

import fzz.wsback.dao.ShippingAddressDao;
import fzz.wsback.domain.ShippingAddress;
import fzz.wsback.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJH
 */
@Service(value = "shippingAddressService")
public class ShippingAddressServiceImpl implements ShippingAddressService {
    private ShippingAddressDao shippingAddressDao = null;

    @Autowired
    public ShippingAddressServiceImpl (ShippingAddressDao shippingAddressDao){
        this.shippingAddressDao = shippingAddressDao;
    }

    @Override
    public List<ShippingAddress> getShippingAddressByUserPhone(String userPhone) {
        return shippingAddressDao.getShippingAddressByUserPhone(userPhone);
    }

    @Override
    public void updateShippingAddress(Integer id,String userPhone, String consignee, String province, String city, String address, String postPhone) {
        shippingAddressDao.updateShippingAddress(id,userPhone,consignee,province,city,address,postPhone);
    }
}
