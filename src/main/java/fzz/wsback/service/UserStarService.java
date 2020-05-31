package fzz.wsback.service;

import com.alibaba.fastjson.JSONArray;
import fzz.wsback.domain.UserStar;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户收藏操作 SERVICE 层
 */
@Repository(value = "UserStarService")
public interface UserStarService {
    /**
     * 通过用户 ID 获取用户收藏图书信息（此处 user_tag 应为 0）
     *
     * @param userId 用户 ID
     * @return JSONArray
     */
    JSONArray getBookUserStarByUserId(Integer userId);

    /**
     * 通过用户 ID 获取用户收藏店铺信息（此处 user_tag 应为 1）
     *
     * @param userId 用户 ID
     * @return JSONArray
     */
    JSONArray getBusinessUserStarByUserId(Integer userId);

    /**
     * 通过用户 ID 和 收藏项 ID 获取用户收藏信息
     *
     * @param userId 用户 ID
     * @param userStarId 用户收藏项 ID
     * @return UserStar
     */
    UserStar getUserStarByUserIdAndUserStarId(Integer userId,
                                              Integer userStarId);

    /**
     * 用户添加收藏（userTag 为 0 表示收藏图书，为 1 表示收藏店铺）
     *
     * @param userId 用户 ID
     * @param userStarId 用户收藏对象 ID
     * @param userStarTag 用户收藏对象标识
     */
    void insertUserStar(Integer userId,
                        Integer userStarId,
                        Integer userStarTag);

    /**
     * 修改用户收藏项状态
     *
     * @param userId     用户 ID
     * @param userStarId 用户收藏对象 ID
     */
    void updateUserStar(Integer userId,
                        Integer userStarId);

    /**
     * 修改用户收藏项状态
     *
     * @param userId     用户 ID
     * @param userStarId 用户收藏对象 ID
     */
    void updateUserStarActive(Integer userId,
                              Integer userStarId);
}
