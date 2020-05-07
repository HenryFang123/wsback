package fzz.wsback.controller;

import fzz.wsback.domain.BookInfo;
import fzz.wsback.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author NE
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllBook")
    public List<BookInfo> getAllBook(@RequestParam(value = "businessId", required = false) Integer businessId,
                                     @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        System.out.println(businessId + pageIndex + pageSize);
        Integer firstIndex = (pageIndex - 1) * pageSize;
        return bookService.getAllBook(businessId, firstIndex, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookCount")
    public Long getBookCount(Integer businessId) {
        System.out.println("businessId是" + businessId);
        System.out.println("总共" + bookService.getBookCount(businessId));
        return bookService.getBookCount(businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBook")
    public void deleteBook(Integer bookId) {
        bookService.deleteBook(bookId);
    }

    @ResponseBody
    @RequestMapping(value = "/getBookByName")
    public List<BookInfo> getBookByName(String bookName) {
        return bookService.getBookByName(bookName);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBookByName")
    public void deleteBookByName(String bookName, Integer businessId) {
        bookService.deleteBookByName(bookName, businessId);
    }

    @ResponseBody
    @RequestMapping(value = "/updateBookInfo")
    public void updateBookInfo(Integer businessId, String bookName, String bookImagePath, Double bookPrice, String bookDescription) {
        bookService.updateBookInfo(businessId, bookName, bookImagePath, bookPrice, bookDescription);
    }

    @ResponseBody
    @RequestMapping(value = "/insertBook")
    public void insertBook(Integer businessId, Integer bookId, String bookName, String bookImagePath, String bookAuthor,
                           String bookPub, String bookYear, String bookIsbn, Double bookPrice, String bookDescription) {
        bookService.insertBook(businessId, bookId, bookName, bookImagePath, bookAuthor, bookPub, bookYear, bookIsbn, bookPrice, bookDescription);
    }
}
