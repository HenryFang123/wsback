package fzz.wsback.dao;

import fzz.wsback.domain.BookComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 12:24
 * @description
 */
@Repository(value = "BookCommentDao")
public interface BookCommentDao {
    /**
     * 通过书籍 ID 获取相关的评论信息
     *
     * @param bookId 书籍 ID
     * @return List BookComment 实体类对象列表
     */
    List<BookComment> getBookCommentListByBookId(@Param(value = "bookId") Integer bookId);
}
