package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-29 15:55
 * @description 图书被操作权重
 */
@Data
public class BookOperateNumber {
    private Integer bookId;
    private Integer businessId;
    private Integer clickNumber;
    private Integer addNumber;
}
