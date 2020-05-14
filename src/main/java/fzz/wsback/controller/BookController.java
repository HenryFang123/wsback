package fzz.wsback.controller;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.BookInfo;
import fzz.wsback.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author NE
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInfoByBookName", method = RequestMethod.POST)
    public List<BookInfo> getBookInfoByBookName(@RequestParam(value = "bookName", required = false) String bookName) {
        return bookService.getBookInfoByBookName(bookName);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInfoListByBusinessId", method = RequestMethod.POST)
    public List<BookInfo> getBookInfoListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                      @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                                      @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Integer pageStart = (pageIndex - 1) * pageSize;
        return bookService.getBookInfoListByBusinessId(businessId, pageStart, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInfoTypeListByBusinessId", produces = {"application/json;charset=UTF-8"},  method = RequestMethod.POST)
    public JSONArray getBookInfoTypeListByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return bookService.getBookInfoTypeListByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInfoListByBusinessIdAndTypeId", produces = {"application/json;charset=UTF-8"},  method = RequestMethod.POST)
    public List<BookInfo> getBookInfoListByBusinessIdAndTypeId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                               @RequestParam(value = "typeId", required = false) Integer typeId,
                                                               @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                                               @RequestParam(value = "pageSize", required = false) Integer pageSize){
        Integer pageStart = (pageNum - 1) * pageSize;
        return bookService.getBookInfoListByBusinessIdAndTypeId(businessId, typeId, pageStart, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInfoCountByBusinessId", method = RequestMethod.POST)
    public Long getBookInfoCountByBusinessId(@RequestParam(value = "businessId", required = false) Integer businessId) {
        return bookService.getBookInfoCountByBusinessId(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookInfoCountByBusinessIdAndTypeId", method = RequestMethod.POST)
    public Long getBookInfoCountByBusinessIdAndTypeId(@RequestParam(value = "businessId", required = false) Integer businessId,
                                                      @RequestParam(value = "typeId", required = false) Integer typeId){
        return bookService.getBookInfoCountByBusinessIdAndTypeId(businessId, typeId);
    }

    @ResponseBody
    @RequestMapping(value = "/insertBookInfo", method = RequestMethod.POST)
    public void insertBookInfo(@RequestParam(value = "businessId", required = false) Integer businessId,
                               @RequestParam(value = "bookName", required = false) String bookName,
                               @RequestParam(value = "bookImagePath", required = false) String bookImagePath,
                               @RequestParam(value = "bookAuthor", required = false) String bookAuthor,
                               @RequestParam(value = "bookPub", required = false) String bookPub,
                               @RequestParam(value = "bookYear", required = false) String bookYear,
                               @RequestParam(value = "bookIsbn", required = false) String bookIsbn,
                               @RequestParam(value = "bookPrice", required = false) Double bookPrice,
                               @RequestParam(value = "bookDescription", required = false) String bookDescription) {
        bookService.insertBookInfo(businessId, bookName, bookImagePath, bookAuthor, bookPub, bookYear, bookIsbn, bookPrice, bookDescription);
    }

    @ResponseBody
    @RequestMapping(value = "/updateBookInfo", method = RequestMethod.POST)
    public void updateBookInfo(@RequestParam(value = "businessId", required = false) Integer businessId,
                               @RequestParam(value = "bookName", required = false) String bookName,
                               @RequestParam(value = "bookImagePath", required = false) String bookImagePath,
                               @RequestParam(value = "bookPrice", required = false) Double bookPrice,
                               @RequestParam(value = "bookDescription", required = false) String bookDescription) {
        bookService.updateBookInfo(businessId, bookName, bookImagePath, bookPrice, bookDescription);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBookInfoByBookId", method = RequestMethod.POST)
    public void deleteBook(@RequestParam(value = "bookId", required = false) Integer bookId) {
        bookService.deleteBookInfoByBookId(bookId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBookInfoByBookNameAndBusinessId", method = RequestMethod.POST)
    public void deleteBookInfoByBookNameAndBusinessId(@RequestParam(value = "bookName", required = false) String bookName,
                                                      @RequestParam(value = "businessId", required = false) Integer businessId) {
        bookService.deleteBookInfoByBookNameAndBusinessId(bookName, businessId);
    }
}
