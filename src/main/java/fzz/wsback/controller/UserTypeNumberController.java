package fzz.wsback.controller;

import fzz.wsback.domain.UserTypeNumber;
import fzz.wsback.service.UserTypeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 16:03
 * @description
 */
@Controller
@RequestMapping(value = "/userTypeNumber")
public class UserTypeNumberController {
    private UserTypeNumberService userTypeNumberService;

    @Autowired
    public UserTypeNumberController(UserTypeNumberService userTypeNumberService){
        this.userTypeNumberService = userTypeNumberService;
    }

    @ResponseBody
    @RequestMapping(value = "/operateUserTypeNumber", method = RequestMethod.POST)
    public void operateUserTypeNumber(UserTypeNumber userTypeNumber){
        if (userTypeNumberService.getUserTypeNumberByUserIdAndBookTypeId(userTypeNumber.getUserId(), userTypeNumber.getBookTypeId()) != null){
            userTypeNumberService.updateUserTypeNumber(userTypeNumber);
        } else {
            userTypeNumberService.insertUserTypeNumber(userTypeNumber);
        }
    }
}
