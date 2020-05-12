package fzz.wsback.service;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.BookInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository(value = "bookService")
public interface BookService {
    /**
     * 通过书籍 ID 获取书籍信息
     *
     * @param bookId 书籍 ID
     * @return BookInfo
     */
    BookInfo getBookInfoById(Integer bookId);

    /**
     * 通过书籍名称获取书籍信息
     *
     * @param bookName 书籍名称
     * @return List BookInfo实体类对象列表
     */
    List<BookInfo> getBookInfoByBookName(String bookName);

    /**
     * 通过店铺 ID、分页起始位置、分页大小获取页内书籍信息列表
     *
     * @param businessId 店铺 ID
     * @param firstIndex 分页起始位置
     * @param pageSize 分页大小
     * @return List BookInfo 实体类对象列表
     */
    List<BookInfo> getBookInfoListByBusinessId(Integer businessId,
                                               Integer firstIndex,
                                               Integer pageSize);

    /**
     * 通过店铺 ID 获取该店铺内类型信息列表
     *
     * @param businessId 店铺 ID
     * @return JSONArray
     */
    JSONArray getBookInfoTypeListByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID、类型 ID、分页起始位置、分页大小获取当前页所需数据
     *
     * @param businessId 店铺 ID
     * @param typeId 类型 ID
     * @param pageStart 页起始数据位置
     * @param pageSize 页大小
     * @return List BookInfo 实体类对象列表
     */
    List<BookInfo> getBookInfoListByBusinessIdAndTypeId(Integer businessId,
                                                        Integer typeId,
                                                        Integer pageStart,
                                                        Integer pageSize);

    /**
     * 通过店铺 ID 获取该店铺下所有书籍总数
     *
     * @param businessId 店铺 ID
     * @return Long 书籍总数
     */
    Long getBookInfoCountByBusinessId(Integer businessId);

    /**
     * 通过店铺 ID 和 类型 ID 获取当前分类下的总书籍个数
     *
     * @param businessId 店铺 ID
     * @param typeId 类型 ID
     * @return Long 书籍总数
     */
    Long getBookInfoCountByBusinessIdAndTypeId(Integer businessId,
                                               Integer typeId);

    /**
     * 插入书籍信息
     *
     * @param businessId 店铺 ID
     * @param bookName 书籍名
     * @param bookImagePath 书籍图片路径
     * @param bookAuthor 书籍作者
     * @param bookPub 书籍出版社
     * @param bookYear 书籍出版年
     * @param bookIsbn 书籍 ISBN 号
     * @param bookPrice 书籍价格
     * @param bookDescription 书籍描述
     */
    void insertBookInfo(Integer businessId,
                        String bookName,
                        String bookImagePath,
                        String bookAuthor,
                        String bookPub,
                        String bookYear,
                        String bookIsbn,
                        Double bookPrice,
                        String bookDescription);

    /**
     * 更新书籍信息
     *
     * @param businessId 店铺 ID
     * @param bookName 书籍名称
     * @param bookImagePath 书籍图片路径
     * @param bookPrice 书记价格
     * @param bookDescription 书籍描述
     */
    void updateBookInfo(Integer businessId,
                        String bookName,
                        String bookImagePath,
                        Double bookPrice,
                        String bookDescription);

    /**
     * 通过书籍 ID 删除该条书籍
     *
     * @param bookId 书籍 ID
     */
    void deleteBookInfoByBookId(Integer bookId);

    /**
     * 通过书籍名称、店铺 ID删除该条书籍信息
     *
     * @param bookName 书籍名称
     * @param businessId 店铺 ID
     */
    void deleteBookInfoByBookNameAndBusinessId(String bookName,
                                               Integer businessId);
}
