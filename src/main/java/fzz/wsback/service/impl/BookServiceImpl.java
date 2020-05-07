package fzz.wsback.service.impl;

import fzz.wsback.dao.BookDao;
import fzz.wsback.domain.BookInfo;
import fzz.wsback.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NE
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public BookInfo getBookInfoById(Integer bookId) {
        return bookDao.getBookInfoById(bookId);
    }

    @Override
    public List<BookInfo> getAllBook(Integer businessId, Integer firstIndex, Integer pageSize) {

        return bookDao.getAllBook(businessId, firstIndex, pageSize);
    }

    @Override
    public Long getBookCount(Integer businessId) {
        System.out.println("bookService里count：" + bookDao.getBookCount(businessId));
        return bookDao.getBookCount(businessId);
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookDao.deleteBook(bookId);
    }

    @Override
    public List<BookInfo> getBookByName(String bookName) {
        return bookDao.getBookByName(bookName);
    }

    @Override
    public void deleteBookByName(String bookName, Integer businessId) {
        bookDao.deleteBookByName(bookName, businessId);
    }

    @Override
    public void updateBookInfo(Integer businessId, String bookName, String bookImagePath, Double bookPrice, String bookDescription) {
        bookDao.updateBookInfo(businessId, bookName, bookImagePath, bookPrice, bookDescription);
    }

    @Override
    public void insertBook(Integer businessId, Integer bookId, String bookName, String bookImagePath, String bookAuthor, String bookPub, String bookYear, String bookIsbn, Double bookPrice, String bookDescription) {
        bookDao.insertBook(businessId, bookId, bookName, bookImagePath, bookAuthor, bookPub, bookYear, bookIsbn, bookPrice, bookDescription);
    }
}
