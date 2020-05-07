package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.Admin;
import fzz.wsback.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ResponseBody
    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@RequestParam(value = "adminId", required = false) Integer adminId,
                             @RequestParam(value = "adminPassword", required = false) String adminPassword,
                             Model model) {
        Admin admin = null;
        admin = adminService.checkLogin(adminId, adminPassword);

        if (admin != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("resultCode", '0');
            jsonObject.put("adminName", admin.getAdminName());
            jsonObject.put("businessId", admin.getBusinessId());
            return jsonObject.toString();
        } else {
            return "{\"resultCode\":\"1\"}";
        }
    }
}
