package fzz.wsback.dao;

import fzz.wsback.domain.BookInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository("BookDao")
public interface BookDao {
    /**
     * get data from mysql by book id.
     *
     * @param bookId
     * @return BookInfo
     */
    BookInfo getBookInfoById(@Param("bookId") Integer bookId);

    List<BookInfo> getAllBook(@Param("businessId") Integer businessId, @Param("firstIndex") Integer firstIndex, @Param("pageSize") Integer pageSize);

    Long getBookCount(@Param("businessId") Integer businessId);

    void deleteBook(@Param("bookId") Integer bookId);

    List<BookInfo> getBookByName(@Param("bookName") String bookName);

    void deleteBookByName(@Param("bookName") String bookName, @Param("businessId") Integer businessId);

    void updateBookInfo(@Param("businessId") Integer businessId, @Param("bookName") String bookName, @Param("bookImagePath") String bookImagePath, @Param("bookPrice") Double bookPrice, @Param("bookDescription") String bookDescription);

    void insertBook(@Param("businessId") Integer businessId, @Param("bookId") Integer bookId, @Param("bookName") String bookName, @Param("bookImagePath") String bookImagePath,
                    @Param("bookAuthor") String bookAuthor,
                    @Param("bookPub") String bookPub, @Param("bookYear") String bookYear, @Param("bookIsbn") String bookIsbn,
                    @Param("bookPrice") Double bookPrice, @Param("bookDescription") String bookDescription);
}
