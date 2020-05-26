package fzz.wsback.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.User;
import fzz.wsback.service.UserService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户操作控制层
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject checkLogin(@RequestParam(value = "userSelf", required = false) String userPhone,
                                 @RequestParam(value = "userPassWord", required = false) String userPassWord) {
        JSONObject jsonObject = new JSONObject();
        User user = userService.checkLogin(userPhone, userPassWord);

        if (user != null) {
            jsonObject.put("resultCode", '1');
            jsonObject.put("userInfoObject", JSONObject.toJSON(user));
        } else {
            jsonObject.put("resultCode", '0');
        }
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/doRegister", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject doRegister(@RequestParam(value = "userId", required = false) Integer userId,
                                 @RequestParam(value = "userName", required = false) String userName,
                                 @RequestParam(value = "userPassWord", required = false) String userPassWord,
                                 @RequestParam(value = "userPhone", required = false) String userPhone,
                                 @RequestParam(value = "userTar", required = false) Integer userTar) {
        JSONObject jsonObject = new JSONObject();

        if (userService.doRegister(userId, userName, userPassWord, userPhone, userTar) == 0) {
            // 失败标志
            jsonObject.put("resultCode", '0');
        } else {
            // 成功标志
            jsonObject.put("resultCode", '1');
            jsonObject.put("userInfoObject", JSONObject.toJSON(userService.getUserInfoByUserId(userId)));
        }
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserPhoneAndAddressByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getUserPhoneAndAddressByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userPhone", userService.getUserPhoneByUserId(userId));
        jsonObject.put("userAddress", userService.getUserAddressByUserId(userId));
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserInfoByUserPhone", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getUserInfoByUserPhone(@RequestParam(value = "userPhone", required = false) String userPhone) {
        return (JSONObject) JSONObject.toJSON(userService.getUserInfoByUserPhone(userPhone));
    }

    @ResponseBody
    @RequestMapping(value = "/getUserInfoByUserId", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getUserInfoByUserId(@RequestParam(value = "userId", required = false) Integer userId) {
        return (JSONObject) JSONObject.toJSON(userService.getUserInfoByUserId(userId));
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public void updateUserInfo(@RequestParam(value = "userImagePath", required = false) String userImagePath,
                               @RequestParam(value = "userPhone", required = false) String userPhone,
                               @RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "userEmail", required = false) String userEmail,
                               @RequestParam(value = "userSex", required = false) String userSex,
                               @RequestParam(value = "userAge", required = false) Integer userAge,
                               @RequestParam(value = "userProvince", required = false) String userProvince,
                               @RequestParam(value = "userCity", required = false) String userCity,
                               @RequestParam(value = "userRegion",required = false)String userRegion,
                               @RequestParam(value = "userAddress", required = false) String userAddress) {
        userService.updateUserInfo(userImagePath, userPhone, userName, userEmail, userSex, userAge, userProvince, userCity,userRegion, userAddress);
    }
}
