package fzz.wsback.dao;

import fzz.wsback.domain.BookInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 书籍操作 DAO 层
 */
@Repository(value = "BookDao")
public interface BookDao {
    /**
     * 通过书籍 ID 获取书籍信息
     *
     * @param bookId 书籍 ID
     * @return BookInfo
     */
    BookInfo getBookInfoById(@Param("bookId") Integer bookId);

    /**
     * 通过书籍名称获取书籍信息
     *
     * @param bookName 书籍名称
     * @return List BookInfo实体类对象列表
     */
    List<BookInfo> getBookInfoByBookName(@Param("bookName") String bookName);

    /**
     * 通过店铺 ID、分页起始位置、分页大小获取页内书籍信息列表
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize   分页大小
     * @return List BookInfo 实体类对象列表
     */
    List<BookInfo> getBookInfoListByBusinessId(@Param("businessId") Integer businessId,
                                               @Param("firstIndex") Integer firstIndex,
                                               @Param("pageSize") Integer pageSize);

    /**
     * 通过店铺 ID 获取该店铺内类型信息列表
     *
     * @param businessId 店铺 ID
     * @return List Integer
     */
    List<Integer> getBookInfoTypeListByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过店铺 ID、类型 ID、分页起始位置、分页大小获取当前页所需数据
     *
     * @param businessId 店铺 ID
     * @param typeId 类型 ID
     * @param pageStart 页起始数据位置
     * @param pageSize 页大小
     * @return List BookInfo 实体类对象列表
     */
    List<BookInfo> getBookInfoListByBusinessIdAndTypeId(@Param("businessId") Integer businessId,
                                                        @Param("typeId") Integer typeId,
                                                        @Param("pageStart") Integer pageStart,
                                                        @Param("pageSize") Integer pageSize);

    /**
     * 通过店铺 ID 获取该店铺下所有书籍总数
     *
     * @param businessId 店铺 ID
     * @return Long 书籍总数
     */
    Long getBookInfoCountByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过店铺 ID 和 类型 ID 获取当前分类下的总书籍个数
     *
     * @param businessId 店铺 ID
     * @param typeId     类型 ID
     * @return Long 书籍总数
     */
    Long getBookInfoCountByBusinessIdAndTypeId(@Param("businessId") Integer businessId,
                                               @Param("typeId") Integer typeId);

    /**
     * 插入书籍信息
     *
     * @param businessId      店铺 ID
     * @param bookName        书籍名
     * @param bookImagePath   书籍图片路径
     * @param bookAuthor      书籍作者
     * @param bookPub         书籍出版社
     * @param bookYear        书籍出版年
     * @param bookIsbn        书籍 ISBN 号
     * @param bookPrice       书籍价格
     * @param bookDescription 书籍描述
     */
    void insertBookInfo(@Param("businessId") Integer businessId,
                        @Param("bookName") String bookName,
                        @Param("bookImagePath") String bookImagePath,
                        @Param("bookAuthor") String bookAuthor,
                        @Param("bookPub") String bookPub,
                        @Param("bookYear") String bookYear,
                        @Param("bookIsbn") String bookIsbn,
                        @Param("bookPrice") Double bookPrice,
                        @Param("bookDescription") String bookDescription);

    /**
     * 更新书籍信息
     *
     * @param businessId      店铺 ID
     * @param bookName        书籍名称
     * @param bookImagePath   书籍图片路径
     * @param bookPrice       书记价格
     * @param bookDescription 书籍描述
     */
    void updateBookInfo(@Param("businessId") Integer businessId,
                        @Param("bookName") String bookName,
                        @Param("bookImagePath") String bookImagePath,
                        @Param("bookPrice") Double bookPrice,
                        @Param("bookDescription") String bookDescription);

    /**
     * 通过书籍 ID 删除该条书籍
     *
     * @param bookId 书籍 ID
     */
    void deleteBookInfoByBookId(@Param("bookId") Integer bookId);

    /**
     * 通过书籍名称、店铺 ID删除该条书籍信息
     *
     * @param bookName   书籍名称
     * @param businessId 店铺 ID
     */
    void deleteBookInfoByBookNameAndBusinessId(@Param("bookName") String bookName,
                                               @Param("businessId") Integer businessId);
}
