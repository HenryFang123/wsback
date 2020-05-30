package fzz.wsback.controller;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.BookComment;
import fzz.wsback.service.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 11:25
 * @description
 */
@Controller
@RequestMapping(value = "/bookComment")
public class BookCommentController {
    private BookCommentService bookCommentService;

    @Autowired
    public BookCommentController(BookCommentService bookCommentService){
        this.bookCommentService = bookCommentService;
    }

    @ResponseBody
    @RequestMapping(value = "/getBookCommentAnalyseByBookId", method = RequestMethod.POST)
    public JSONObject getBookCommentAnalyseByBookId(@RequestParam(value = "bookId", required = false) Integer bookId) {
        return bookCommentService.getBookCommentAnalyseByBookId(bookId);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookCommentListByBookId", method = RequestMethod.POST)
    public JSONObject getBookCommentListByBookId(@RequestParam(value = "bookId", required = false) Integer bookId) {
        JSONObject jsonObject = new JSONObject();
        List<BookComment> bookCommentList = bookCommentService.getBookCommentListByBookId(bookId);

        if (!bookCommentList.isEmpty()) {
            jsonObject.put("resultCode", '1');
            jsonObject.put("bookCommentList", bookCommentList);
        } else {
            jsonObject.put("resultCode", '0');
        }
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/insertBookComment", method = RequestMethod.POST)
    public void insertBookComment(BookComment bookComment) {
        bookCommentService.insertBookComment(bookComment);
    }
}
