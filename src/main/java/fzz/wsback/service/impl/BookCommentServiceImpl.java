package fzz.wsback.service.impl;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.dao.BookCommentDao;
import fzz.wsback.dao.BookDao;
import fzz.wsback.domain.BookComment;
import fzz.wsback.service.BookCommentService;
import fzz.wsback.utils.FileOperateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 15:07
 * @description 用户针对书籍的评论 SERVICE 层实现
 */
@Service(value = "BookCommentService")
public class BookCommentServiceImpl implements BookCommentService {
    private BookDao bookDao;
    private BookCommentDao bookCommentDao;

    @Autowired
    public BookCommentServiceImpl(BookDao bookDao, BookCommentDao bookCommentDao){
        this.bookDao = bookDao;
        this.bookCommentDao = bookCommentDao;
    }

    @Override
    public JSONObject getBookCommentAnalyseByBookId(Integer bookId) {
        JSONObject jsonObject = new JSONObject();
        List<Long> remarksNumList = new ArrayList<Long>();

        Long goodCommentCount = bookCommentDao.getBookCommentGoodCountByBookId(bookId);
        Long notGoodCommentCount = bookCommentDao.getBookCommentNotGoodCountByBookId(bookId);
        Long badCommentCount = bookCommentDao.getBookCommentBadCountByBookId(bookId);

        Double goodRating = goodCommentCount / (double)(goodCommentCount + notGoodCommentCount + badCommentCount);
        remarksNumList.add(goodCommentCount);
        remarksNumList.add(notGoodCommentCount);
        remarksNumList.add(badCommentCount);

        jsonObject.put("goodRating", goodRating);
        jsonObject.put("remarksNumList", remarksNumList);

        return jsonObject;
    }

    @Override
    public List<BookComment> getBookCommentListByBookId(Integer bookId) {
        return bookCommentDao.getBookCommentListByBookId(bookId);
    }

    @Override
    public void insertBookComment(BookComment bookComment) {
        bookCommentDao.insertBookComment(bookComment.getUserId(), bookComment.getBookId(), bookComment.getContent(), bookComment.getRating());
        FileOperateUtil.writeToUserBookRatingFile(bookComment.getUserId(), bookComment.getBookId(), bookComment.getRating(), bookDao.getBookInfoById(bookComment.getBookId()).getBookTypeId());
    }
}
