package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.service.BusinessService;
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
 * @description 店铺操作控制层
 */
@Controller
@RequestMapping(value = "/business")
public class BusinessController {
    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @ResponseBody
    @RequestMapping(value = "/getBusinessInfoByBusinessId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getBusinessInfoByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return (JSONObject) JSONObject.toJSON(businessService.getBusinessInfoByBusinessId(businessId));
    }

    @ResponseBody
    @RequestMapping(value = "/getBusinessInfoByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject checkLogin(@RequestParam(value = "userId", required = false) Integer userId) {
        return (JSONObject) JSONObject.toJSON(businessService.getBusinessInfoByUserId(userId));
    }
}
