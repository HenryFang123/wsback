package fzz.wsback.controller;

import fzz.wsback.service.BookOperateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-29 18:27
 * @description 操作前端传回权重值（点击图书、加购图书等）控制层
 */
@Controller
@RequestMapping(value = "/bookOperateNumber")
public class BookOperateNumberController {
    private BookOperateNumberService bookOperateNumberService;

    @Autowired
    public BookOperateNumberController(BookOperateNumberService bookOperateNumberService){
        this.bookOperateNumberService = bookOperateNumberService;
    }

    @ResponseBody
    @RequestMapping(value = "/operateClickBook", method = RequestMethod.POST)
    public void operateClickBook(@RequestParam(value = "bookId", required = false) Integer bookId,
                                 @RequestParam(value = "businessId", required = false) Integer businessId,
                                 @RequestParam(value = "clickNumber", required = false) Integer clickNumber) {
        if (bookOperateNumberService.getBookOperateNumberByBookId(bookId) == null) {
            bookOperateNumberService.insertBookOperateNumber(bookId, businessId, clickNumber, 0);
        } else {
            bookOperateNumberService.updateBookOperateNumberClick(bookId, clickNumber);
        }
    }
}
