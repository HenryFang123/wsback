package fzz.wsback.dao;

import fzz.wsback.domain.BookComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 12:24
 * @description 用户针对书籍的评论 DAO 层
 */
@Repository(value = "BookCommentDao")
public interface BookCommentDao {
    /**
     * 通过书籍 ID 获取评论信息（好评总计）
     *
     * @param bookId 书籍 ID
     * @return LONG 类型
     */
    Long getBookCommentGoodCountByBookId(@Param(value = "bookId") Integer bookId);

    /**
     * 通过书籍 ID 获取评论信息（良好评总计）
     *
     * @param bookId 书籍 ID
     * @return LONG 类型
     */
    Long getBookCommentNotGoodCountByBookId(@Param(value = "bookId") Integer bookId);

    /**
     * 通过书籍 ID 获取评论信息（差评总计）
     *
     * @param bookId 书籍 ID
     * @return LONG 类型
     */
    Long getBookCommentBadCountByBookId(@Param(value = "bookId") Integer bookId);

    /**
     * 通过书籍 ID 获取相关的评论信息
     *
     * @param bookId 书籍 ID
     * @return List BookCommentService 实体类对象列表
     */
    List<BookComment> getBookCommentListByBookId(@Param(value = "bookId") Integer bookId);

    /**
     * 插入评论信息
     *
     * @param userId 用户 ID
     * @param bookId 书籍 ID
     * @param content 评论内容
     * @param rating 评分
     */
    void insertBookComment(@Param(value = "userId") Integer userId,
                           @Param(value = "bookId") Integer bookId,
                           @Param(value = "content") String content,
                           @Param(value = "rating") Float rating);
}
