package fzz.wsback.service;

import fzz.wsback.domain.UserTypeNumber;
import org.springframework.stereotype.Repository;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 15:34
 * @description 用户对类型权重 SERVICE 层
 */
@Repository(value = "UserTypeNumberService")
public interface UserTypeNumberService {
    /**
     * 通过用户 ID 以及 书籍类型 ID 获取用户类型权重实体
     *
     * @param userId 用户 ID
     * @param bookTypeId 书籍类型 ID
     * @return 实体类对象UserTypeNumber
     */
    UserTypeNumber getUserTypeNumberByUserIdAndBookTypeId(Integer userId,
                                                          Integer bookTypeId);

    /**
     * 插入用户对类型权重
     *
     * @param userTypeNumber 用户对类型权重对象
     */
    void insertUserTypeNumber(UserTypeNumber userTypeNumber);

    /**
     * 更新用户对类型权重
     *
     * @param userTypeNumber 用户对类型权重对象
     */
    void updateUserTypeNumber(UserTypeNumber userTypeNumber);
}
