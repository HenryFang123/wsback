package fzz.wsback.service;

import com.alibaba.fastjson.JSONObject;
import fzz.wsback.domain.BookComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 15:05
 * @description 用户针对书籍的评论 SERVICE 层
 */
@Repository(value = "BookCommentService")
public interface BookCommentService {
    /**
     * 通过书籍 ID 获取评论分析）
     *
     * @param bookId 书籍 ID
     * @return JSONObject
     */
    JSONObject getBookCommentAnalyseByBookId(@Param(value = "bookId") Integer bookId);

    /**
     * 通过书籍 ID 获取相关的评论信息
     *
     * @param bookId 书籍 ID
     * @return List BookCommentService 实体类对象列表
     */
    List<BookComment> getBookCommentListByBookId(Integer bookId);

    /**
     * 插入评论信息
     *
     * @param bookComment 书籍评论对象
     */
    void insertBookComment(BookComment bookComment);
}
