package fzz.wsback.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-28 21:44
 * @description 系统推荐控制层
 */
@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {
    private RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @ResponseBody
    @RequestMapping(value = "/getRecommendMahoutByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getRecommendMahout(@RequestParam("userId") Integer userId) {
        JSONObject jsonObject = new JSONObject();
        JSONArray recommendMahoutJsonArray = recommendService.getRecommendMahout(userId);

        if (recommendMahoutJsonArray.isEmpty()) {
            jsonObject.put("resultCode", '0');
        } else {
            jsonObject.put("resultCode", '1');
            jsonObject.put("recommendBookListM", recommendMahoutJsonArray);
        }

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/getRecommendSystem", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getRecommendSystem() {
        JSONObject jsonObject = new JSONObject();
        JSONArray recommendSystemJsonArray = recommendService.getRecommendSystem();

        if (recommendSystemJsonArray.isEmpty()) {
            jsonObject.put("resultCode", '0');
        } else {
            jsonObject.put("resultCode", '1');
            jsonObject.put("recommendBookListS", recommendSystemJsonArray);
        }

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/getRecommendSystemHot", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONArray getRecommendSystemHot() {
        return recommendService.getRecommendSystemHot();
    }

    @ResponseBody
    @RequestMapping(value = "/getRecommendBusinessHot", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONArray getRecommendBusinessHot(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return recommendService.getRecommendBusinessHot(businessId);
    }
}
