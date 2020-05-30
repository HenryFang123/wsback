package fzz.wsback.dao;

import fzz.wsback.domain.UserTypeNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 15:27
 * @description 用户对类型权重 DAO 层
 */
@Repository(value = "UserTypeNumberDao")
public interface UserTypeNumberDao {
    /**
     * 获取用户类型权重 Top5
     *
     * @param userId 用户 ID
     * @return List Integer 类型列表
     */
    List<Integer> getUserTypeNumberTop5ByUserId(@Param(value = "userId") Integer userId);

    /**
     * 通过用户 ID 以及 书籍类型 ID 获取用户类型权重实体
     *
     * @param userId 用户 ID
     * @param bookTypeId 书籍类型 ID
     * @return 实体类对象UserTypeNumber
     */
    UserTypeNumber getUserTypeNumberByUserIdAndBookTypeId(@Param(value = "userId") Integer userId,
                                                          @Param(value = "bookTypeId") Integer bookTypeId);

    /**
     * 插入用户对类型权重
     *
     * @param userId 用户 ID
     * @param bookTypeId 书籍类型 ID
     * @param number 权重值
     */
    void insertUserTypeNumber(@Param(value = "userId") Integer userId,
                              @Param(value = "bookTypeId") Integer bookTypeId,
                              @Param(value = "number") Integer number);

    /**
     * 更新用户对类型权重
     *
     * @param userId 用户 ID
     * @param bookTypeId 书籍类型 ID
     * @param number 权重值
     */
    void updateUserTypeNumber(@Param(value = "userId") Integer userId,
                              @Param(value = "bookTypeId") Integer bookTypeId,
                              @Param(value = "number") Integer number);
}
