package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.BookInfo;
import fzz.wsback.domain.BusinessInfo;
import fzz.wsback.service.BookService;
import fzz.wsback.service.BusinessService;
import fzz.wsback.service.UtilsService;
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
@RequestMapping("/utils")
public class UtilsController {
    private final UtilsService utilsService;
    private final BookService bookService;
    private final BusinessService businessService;

    @Autowired
    public UtilsController(UtilsService utilsService, BookService bookService, BusinessService businessService) {
        this.utilsService = utilsService;
        this.bookService = bookService;
        this.businessService = businessService;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPhone")
    public String checkPhone(@RequestParam(value = "userPhone", required = false) String userPhone,
                             Model model) {
        Integer userId = utilsService.checkPhone(userPhone);

        if (userId == 0) {
            // 失败标志
            return "{\"resultCode\":\"0\"}";
        } else {
            // 成功标志
            return "{\"resultCode\":\"1\"}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/sendSms")
    public String sendSms(@RequestParam(value = "userPhone", required = false) String userPhone,
                          Model model) {
        Integer phoneCode = utilsService.sendSms(userPhone);

        if (phoneCode == 0) {
            // 失败标志
            return "{\"resultCode\":\"0\"}";
        } else {
            // 成功标志
            return "{\"resultCode\":\"1\",\"phoneCode\":\"" + phoneCode + "\"}";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getInfoById", produces = {"application/json;charset=UTF-8"})
    public String getInfoById(@RequestParam(value = "bookId", required = false) Integer bookId,
                              @RequestParam(value = "businessId", required = false) Integer businessId,
                              Model model) {
        BookInfo bookInfo = null;
        BusinessInfo businessInfo = null;
        bookInfo = bookService.getBookInfoById(bookId);
        businessInfo = businessService.getBusinessInfoById(businessId);

        if (bookInfo != null && businessInfo != null) {
            return "{\"bookInfo\":" + JSONObject.toJSON(bookInfo).toString() + ",\"businessInfo\":" + JSONObject.toJSON(businessInfo).toString() + "}";
        } else {
            return "{\"resultCode\":\"0\"}";
        }
    }
}
