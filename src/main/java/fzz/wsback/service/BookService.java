package fzz.wsback.service;

import fzz.wsback.domain.BookInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository("bookService")
public interface BookService {

    /**
     * get data from mysql by book id.
     *
     * @param bookId
     * @return BookInfo
     */
    BookInfo getBookInfoById(Integer bookId);

    List<BookInfo> getAllBook(Integer businessId, Integer firstIndex, Integer pageSize);

    Long getBookCount(Integer businessId);

    void deleteBook(Integer bookId);

    List<BookInfo> getBookByName(String bookName);

    void deleteBookByName(String bookName, Integer businessId);

    void updateBookInfo(Integer businessId, String bookName, String bookImagePath, Double bookPrice, String bookDescription);

    void insertBook(Integer businessId, Integer bookId, String bookName, String bookImagePath, String bookAuthor,
                    String bookPub, String bookYear, String bookIsbn, Double bookPrice, String bookDescription);
}
