package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.Admin;
import fzz.wsback.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author NE
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject checkLogin(@RequestParam(value = "adminId", required = false) Integer adminId,
                                 @RequestParam(value = "adminPassword", required = false) String adminPassword) {
        JSONObject jsonObject = new JSONObject();
        Admin admin = adminService.checkLogin(adminId, adminPassword);

        if (admin != null) {
            jsonObject.put("resultCode", '1');
            jsonObject.put("adminInfo", JSONObject.toJSON(admin));
        } else {
            jsonObject.put("resultCode", '0');
        }
        return jsonObject;
    }
}
