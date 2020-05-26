package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户针对书籍的评论
 */
@Data
public class BookComment {
    private Integer userId;
    private Integer bookId;
    private String content;
}
