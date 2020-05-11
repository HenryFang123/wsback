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
@Service(value = "bookService")
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
    public List<BookInfo> getBookInfoByBookName(String bookName) {
        return bookDao.getBookInfoByBookName(bookName);
    }

    @Override
    public List<BookInfo> getBookInfoListByBusinessId(Integer businessId, Integer firstIndex, Integer pageSize) {
        return bookDao.getBookInfoListByBusinessId(businessId, firstIndex, pageSize);
    }

    @Override
    public List<BookInfo> getBookInfoListByBusinessIdAndTypeId(Integer businessId, Integer typeId, Integer pageStart, Integer pageSize) {
        return bookDao.getBookInfoListByBusinessIdAndTypeId(businessId, typeId, pageStart, pageSize);
    }

    @Override
    public Long getBookInfoCountByBusinessId(Integer businessId) {
        return bookDao.getBookInfoCountByBusinessId(businessId);
    }

    @Override
    public Long getBookInfoCountByBusinessIdAndTypeId(Integer businessId, Integer typeId) {
        return bookDao.getBookInfoCountByBusinessIdAndTypeId(businessId, typeId);
    }

    @Override
    public void insertBookInfo(Integer businessId, String bookName, String bookImagePath, String bookAuthor, String bookPub, String bookYear, String bookIsbn, Double bookPrice, String bookDescription) {
        bookDao.insertBookInfo(businessId, bookName, bookImagePath, bookAuthor, bookPub, bookYear, bookIsbn, bookPrice, bookDescription);
    }

    @Override
    public void updateBookInfo(Integer businessId, String bookName, String bookImagePath, Double bookPrice, String bookDescription) {
        bookDao.updateBookInfo(businessId, bookName, bookImagePath, bookPrice, bookDescription);
    }

    @Override
    public void deleteBookInfoByBookId(Integer bookId) {
        bookDao.deleteBookInfoByBookId(bookId);
    }

    @Override
    public void deleteBookInfoByBookNameAndBusinessId(String bookName, Integer businessId) {
        bookDao.deleteBookInfoByBookNameAndBusinessId(bookName, businessId);
    }
}
