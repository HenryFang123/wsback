package fzz.wsback.dao;

import fzz.wsback.domain.BookTypeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 书籍类别操作 DAO 层
 */
@Repository(value = "BookTypeDao")
public interface BookTypeDao {
    /**
     * 通过类型 ID 获取相关的类型信息
     *
     * @param bookTypeId 类型 ID
     * @return BookTypeInfo 实体类对象
     */
    BookTypeInfo getBookTypeInfoByBookTypeId(@Param("bookTypeId") Integer bookTypeId);
}
