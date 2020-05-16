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
    public void updateShippingAddress(Integer id,String userPhone, String consignee, String province, String city, String region, String address, String postPhone) {
        shippingAddressDao.updateShippingAddress(id,userPhone,consignee,province,city,region,address,postPhone);
    }

    @Override
    public void insertAddress(String userPhone, String consignee, String province, String city, String region, String address, String postPhone) {
        shippingAddressDao.insertAddress(userPhone,consignee,province,city,region,address,postPhone);
    }

    @Override
    public void deleteShippingAddress(Integer id, String userPhone) {
        shippingAddressDao.deleteShippingAddress(id,userPhone);
    }

    @Override
    public void setDefaultAddress(String userPhone, Integer id) {
        shippingAddressDao.setDefaultAddress(userPhone,id);
    }
}
