package fzz.wsback.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.dao.ShippingAddressDao;
import fzz.wsback.domain.ShippingAddress;
import fzz.wsback.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJH
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户收货地址操作 SERVICE 层实现
 */
@Service(value = "ShippingAddressService")
public class ShippingAddressServiceImpl implements ShippingAddressService {
    private ShippingAddressDao shippingAddressDao = null;

    @Autowired
    public ShippingAddressServiceImpl (ShippingAddressDao shippingAddressDao){
        this.shippingAddressDao = shippingAddressDao;
    }

    @Override
    public List<ShippingAddress> getShippingAddressListByUserPhone(String userPhone) {
        return shippingAddressDao.getShippingAddressListByUserPhone(userPhone);
    }

    @Override
    public JSONArray getShippingAddressListByUserPhoneAndHandle(String userPhone) {
        JSONArray jsonArray = new JSONArray();
        List<ShippingAddress> shippingAddressList = shippingAddressDao.getShippingAddressListByUserPhone(userPhone);

        for (ShippingAddress shippingAddress : shippingAddressList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ifDefaultAddress", shippingAddress.getDefaultAddress());
            jsonObject.put("id", shippingAddress.getId());
            jsonObject.put("detail", shippingAddress.getConsignee()
                    + ' ' + shippingAddress.getPostPhone()
                    + ' ' + shippingAddress.getProvince()
                    + '-' + shippingAddress.getCity()
                    + '-' + shippingAddress.getRegion()
                    + ' ' + shippingAddress.getAddress());

            jsonArray.add(jsonObject);
        }
        return jsonArray;
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
