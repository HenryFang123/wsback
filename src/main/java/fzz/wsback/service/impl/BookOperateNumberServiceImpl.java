package fzz.wsback.service.impl;

import fzz.wsback.dao.BookOperateNumberDao;
import fzz.wsback.domain.BookOperateNumber;
import fzz.wsback.service.BookOperateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-29 17:09
 * @description 图书被操作权重 SERVICE 层实现
 */
@Service(value = "BookOperateNumberService")
public class BookOperateNumberServiceImpl implements BookOperateNumberService {
    private BookOperateNumberDao bookOperateNumberDao;

    @Autowired
    public BookOperateNumberServiceImpl(BookOperateNumberDao bookOperateNumberDao){
        this.bookOperateNumberDao = bookOperateNumberDao;
    }

    @Override
    public BookOperateNumber getBookOperateNumberByBookId(Integer bookId) {
        return bookOperateNumberDao.getBookOperateNumberByBookId(bookId);
    }

    @Override
    public void insertBookOperateNumber(Integer bookId, Integer businessId, Integer clickNumber, Integer addNumber) {
        bookOperateNumberDao.insertBookOperateNumber(bookId, businessId, clickNumber, addNumber);
    }

    @Override
    public void updateBookOperateNumberClick(Integer bookId, Integer clickNumber) {
        bookOperateNumberDao.updateBookOperateNumberClick(bookId, clickNumber);
    }

    @Override
    public void operateClickBook(Integer bookId, Integer businessId, Integer clickNumber) {
        if (bookOperateNumberDao.getBookOperateNumberByBookId(bookId) == null) {
            bookOperateNumberDao.insertBookOperateNumber(bookId, businessId, clickNumber, 0);
        } else {
            bookOperateNumberDao.updateBookOperateNumberClick(bookId, clickNumber);
        }
    }

    @Override
    public void operateAddBook(Integer bookId, Integer businessId, Integer addNumber) {
        if (bookOperateNumberDao.getBookOperateNumberByBookId(bookId) == null) {
            bookOperateNumberDao.insertBookOperateNumber(bookId, businessId, 0, addNumber);
        } else {
            bookOperateNumberDao.updateBookOperateNumberAdd(bookId, addNumber);
        }
    }
}
