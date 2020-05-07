package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.User;
import fzz.wsback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author NE
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@RequestParam(value = "userSelf", required = false) String userPhone,
                             @RequestParam(value = "userPassWord", required = false) String userPassWord,
                             Model model) {
        User user = null;
        user = userService.checkLogin(userPhone, userPassWord);

        if (user != null) {
            return "{\"resultCode\":\"0\",\"userId\":\"" + user.getUserId() + "\"}";
        } else {
            return "{\"resultCode\":\"1\"}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/doRegister")
    public String doRegister(@RequestParam(value = "userId", required = false) String userIdStr,
                             @RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "userPassWord", required = false) String userPassWord,
                             @RequestParam(value = "userPhone", required = false) String userPhone,
                             @RequestParam(value = "userTar", required = false) String userTarStr,
                             Model model) {

        Integer userId = Integer.parseInt(userIdStr);
        Integer userTar = Integer.parseInt(userTarStr);

        Integer registerCode = userService.doRegister(userId, userName, userPassWord, userPhone, userTar);

        if (registerCode == 0) {
            // 失败标志
            return "{\"resultCode\":\"0\"}";
        } else {
            // 成功标志
            return "{\"resultCode\":\"1\"}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findUserPhoneAndAddressByUserId", produces = {"application/json;charset=UTF-8"})
    public String findUserPhoneAndAddressByUserId(Integer userId, Model model) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userPhone", userService.findUserPhoneByUserId(userId));
        jsonObject.put("userAddress", userService.findUserAddressByUserId(userId));
        return jsonObject.toString();
    }
}
