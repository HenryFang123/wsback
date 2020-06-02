package fzz.wsback.service;

import fzz.wsback.domain.BookOperateNumber;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-29 17:07
 * @description 图书被操作权重 SERVICE 层
 */
@Repository(value = "BookOperateNumberService")
public interface BookOperateNumberService {
    /**
     * 通过图书 ID 获取实体
     *
     * @param bookId 图书 ID
     * @return BookOperateNumber 实体类对象
     */
    BookOperateNumber getBookOperateNumberByBookId(Integer bookId);

    /**
     * 插入图书被操作权重
     *
     * @param bookId 图书 ID
     * @param businessId 店铺 ID
     * @param clickNumber 图书被点击权重
     * @param addNumber 图书被加购权重
     */
    void insertBookOperateNumber(Integer bookId,
                                 Integer businessId,
                                 Integer clickNumber,
                                 Integer addNumber);

    /**
     * 更新图书被用户点击权重
     *
     * @param bookId 图书 ID
     * @param clickNumber 图书被点击权重
     */
    void updateBookOperateNumberClick(Integer bookId,
                                      Integer clickNumber);

    /**
     * 操作图书被用户点击权重
     *
     * @param bookId      图书 ID
     * @param businessId  店铺 ID
     * @param clickNumber 图书被点击权重
     */
    void operateClickBook(Integer bookId,
                          Integer businessId,
                          Integer clickNumber);

    /**
     * 操作图书被用户加购权重
     *
     * @param bookId     图书 ID
     * @param businessId 店铺 ID
     * @param addNumber  图书被加购权重
     */
    void operateAddBook(Integer bookId,
                        Integer businessId,
                        Integer addNumber);
}
