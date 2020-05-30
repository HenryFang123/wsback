package fzz.wsback.service;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Repository;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 20:05
 * @description 系统推荐 SERVICE 层
 */
@Repository(value = "RecommendService")
public interface RecommendService {
    /**
     * 通过用户 ID 获取系统推荐的书籍信息
     *
     * @param userId 用户ID
     * @return JSONArray
     */
    JSONArray getRecommendMahout(Integer userId);

    /**
     * 获取系统推荐的书籍信息（未有协同推荐时）
     *
     * @return JSONArray
     */
    JSONArray getRecommendSystem();

    /**
     * 获取系统热门的书籍信息
     *
     * @return JSONArray
     */
    JSONArray getRecommendSystemHot();

    /**
     * 获取店铺热门的书籍信息
     *
     * @param busienssId 店铺 ID
     * @return JSONArray
     */
    JSONArray getRecommendBusinessHot(Integer busienssId);
}
