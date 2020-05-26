package fzz.wsback.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.UserStar;
import fzz.wsback.service.UserStarService;
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
 * @description 用户收藏操作控制层
 */
@Controller
@RequestMapping(value = "/userStar")
public class UserStarController {
    private UserStarService userStarService;

    @Autowired
    public UserStarController(UserStarService userStarService){
        this.userStarService = userStarService;
    }

    @ResponseBody
    @RequestMapping(value = "/getBookUserStarByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONArray getBookUserStarByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return userStarService.getBookUserStarByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getBusinessUserStarByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONArray getBusinessUserStarByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return userStarService.getBusinessUserStarByUserId(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/insertUserStar", method = RequestMethod.POST)
    public void insertUserStar(@RequestParam(value = "userId", required = false) Integer userId,
                               @RequestParam(value = "userStarId", required = false) Integer userStarId,
                               @RequestParam(value = "userStarTag", required = false) Integer userStarTag) {
        UserStar userStar = userStarService.getUserStarByUserIdAndUserStarId(userId, userStarId);

        if (userStar == null){
            userStarService.insertUserStar(userId, userStarId, userStarTag);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserStar", method = RequestMethod.POST)
    public void updateUserStar(@RequestParam(value = "userId", required = false) Integer userId,
                               @RequestParam(value = "userStarId", required = false) Integer userStarId) {
        userStarService.updateUserStar(userId, userStarId);
    }
}
