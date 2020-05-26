package fzz.wsback.domain;


import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 书籍的信息
 */
@Data
public class BookInfo {
    private Integer bookId;
    private String bookImagePath;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private String bookYear;
    private String bookIsbn;
    private Double bookPrice;
    private Integer bookStock;
    private String bookDescription;
    private Float bookRating;
    private Integer bookTypeId;
    private Integer businessId;
    private Integer bookStatus;
}
