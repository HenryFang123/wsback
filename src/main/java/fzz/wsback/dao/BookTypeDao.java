package fzz.wsback.dao;

import fzz.wsback.domain.BookTypeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author NE
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
