package fzz.wsback.service.impl;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.dao.BookCommentDao;
import fzz.wsback.dao.BookDao;
import fzz.wsback.domain.BookComment;
import fzz.wsback.service.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

        Long goodCommentCount = bookCommentDao.getBookCommentGoodCountByBookId(bookId);
        Long notGoodCommentCount = bookCommentDao.getBookCommentNotGoodCountByBookId(bookId);
        Long badCommentCount = bookCommentDao.getBookCommentBadCountByBookId(bookId);

        Integer goodRating = Math.round((float) goodCommentCount / (goodCommentCount + notGoodCommentCount + badCommentCount) * 100);

        jsonObject.put("goodRating", goodRating);
        jsonObject.put("goodNumber", goodCommentCount);
        jsonObject.put("notGoodNumber", notGoodCommentCount);
        jsonObject.put("badNumber", badCommentCount);

        return jsonObject;
    }

    @Override
    public List<BookComment> getBookCommentListByBookId(Integer bookId) {
        return bookCommentDao.getBookCommentListByBookId(bookId);
    }

    @Override
    public void insertBookComment(BookComment bookComment) {
        bookCommentDao.insertBookComment(bookComment.getUserId(), bookComment.getBookId(), bookComment.getContent(), bookComment.getRating());
        bookDao.updateBookCommentNumber(bookComment.getBookId());
        writeToUserBookRatingFile(bookComment.getUserId(), bookComment.getBookId(), bookComment.getRating(), bookDao.getBookInfoById(bookComment.getBookId()).getBookTypeId());
    }

    /**
     * 写入 类型-用户-书籍-评分 文件中，以便进行物品协同推荐
     *
     * @param userId     用户 ID
     * @param bookId     书籍 ID
     * @param wRating    评分 ID
     * @param bookTypeId 书籍类型 ID
     */
    public void writeToUserBookRatingFile(Integer userId, Integer bookId, Float wRating, Integer bookTypeId) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        File file = new File("..\\data\\wsback\\" + String.valueOf(bookTypeId) + ".csv");

        if (file.exists()) {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write(userId + "," + bookId + "," + wRating);
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
