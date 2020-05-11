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
 * @author NE
 */
@Controller
@RequestMapping(value = "/business")
public class BusinessController {
    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @ResponseBody
    @RequestMapping(value = "/getBusinessInfoByBusinessId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject checkLogin(@RequestParam(value = "businessId", required = false) String businessId) {
        return (JSONObject) JSONObject.toJSON(businessService.getBusinessInfoByBusinessId(Integer.valueOf(businessId)));
    }
}
