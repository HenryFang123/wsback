package fzz.wsback.dao;

import fzz.wsback.domain.BookOperateNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-29 15:56
 * @description 图书被操作权重 DAO 层
 */
@Repository(value = "BookOperateNumberDao")
public interface BookOperateNumberDao {
    /**
     * 获取图书被用户点击权重 Top18
     *
     * @return List Integer 类型列表
     */
    List<Integer> getBookOperateNumberClickTop18();

    /**
     * 获取图书被用户加购权重 Top6
     *
     * @return List Integer 类型列表
     */
    List<Integer> getBookOperateNumberAddTop6();

    /**
     * 获取店铺中图书被用户加购权重 Top5
     *
     * @param businessId 店铺 ID
     * @return List Integer 类型列表
     */
    List<Integer> getBookOperateNumberBusinessAddTop5(@Param(value = "businessId") Integer businessId);

    /**
     * 通过图书 ID 获取实体
     *
     * @param bookId 图书 ID
     * @return BookOperateNumber 实体类对象
     */
    BookOperateNumber getBookOperateNumberByBookId(@Param(value = "bookId") Integer bookId);

    /**
     * 插入图书被操作权重
     *
     * @param bookId 图书 ID
     * @param businessId 店铺 ID
     * @param clickNumber 图书被点击权重
     * @param addNumber 图书被加购权重
     */
    void insertBookOperateNumber(@Param(value = "bookId") Integer bookId,
                                 @Param(value = "businessId") Integer businessId,
                                 @Param(value = "clickNumber") Integer clickNumber,
                                 @Param(value = "addNumber") Integer addNumber);

    /**
     * 更新图书被用户点击权重
     *
     * @param bookId 图书 ID
     * @param clickNumber 图书被点击权重
     */
    void updateBookOperateNumberClick(@Param(value = "bookId") Integer bookId,
                                      @Param(value = "clickNumber") Integer clickNumber);

    /**
     * 更新图书被用户加购权重
     *
     * @param bookId 图书 ID
     * @param addNumber 图书被加购权重
     */
    void updateBookOperateNumberAdd(@Param(value = "bookId") Integer bookId,
                                    @Param(value = "addNumber") Integer addNumber);
}
