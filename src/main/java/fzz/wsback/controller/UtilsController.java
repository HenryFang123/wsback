package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.service.BookOperateNumberService;
import fzz.wsback.service.BookService;
import fzz.wsback.service.BusinessService;
import fzz.wsback.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 工具操作控制层
 */
@Controller
@RequestMapping(value = "/utils")
public class UtilsController {
    private UtilsService utilsService;
    private BookService bookService;
    private BusinessService businessService;
    private BookOperateNumberService bookOperateNumberService;

    @Autowired
    public UtilsController(UtilsService utilsService, BookService bookService, BusinessService businessService, BookOperateNumberService bookOperateNumberService) {
        this.utilsService = utilsService;
        this.bookService = bookService;
        this.businessService = businessService;
        this.bookOperateNumberService = bookOperateNumberService;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPhone", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject checkPhone(@RequestParam(value = "userPhone", required = false) String userPhone) {
        JSONObject jsonObject = new JSONObject();

        if (utilsService.checkPhone(userPhone) == 0) {
            // 失败标志
            jsonObject.put("resultCode", '0');
        } else {
            // 成功标志
            jsonObject.put("resultCode", '1');
        }

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/sendSms", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject sendSms(@RequestParam(value = "userPhone", required = false) String userPhone) {
        JSONObject jsonObject = new JSONObject();

        if (utilsService.sendSms(userPhone) == 0) {
            // 失败标志
            jsonObject.put("resultCode", '0');
        } else {
            // 成功标志
            jsonObject.put("resultCode", '1');
            jsonObject.put("phoneCode", utilsService.sendSms(userPhone));
        }

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadBookImage", method = RequestMethod.POST)
    public JSONObject uploadBookImage(@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        JSONObject jsonObject = new JSONObject();
        String bookImagePath = utilsService.uploadBookImage(multipartFile);

        if (!"".equals(bookImagePath)) {
            jsonObject.put("resultCode", '1');
            jsonObject.put("bookImagePath", bookImagePath);
        } else {
            jsonObject.put("resultCode", '0');
        }

        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/getInfoById", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject getInfoById(@RequestParam(value = "bookId", required = false) Integer bookId,
                                  @RequestParam(value = "businessId", required = false) Integer businessId) {
        JSONObject jsonObject = new JSONObject();

        // 用户加购对该图书点击 Click 权重 5
        bookOperateNumberService.operateClickBook(bookId, businessId, 5);

        jsonObject.put("bookInfo", JSONObject.toJSON(bookService.getBookInfoById(bookId)));
        jsonObject.put("businessInfo", JSONObject.toJSON(businessService.getBusinessInfoByBusinessId(businessId)));

        return jsonObject;
    }
}
