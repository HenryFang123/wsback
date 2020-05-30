package fzz.wsback.dao;

import fzz.wsback.domain.BusinessInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 店铺操作 DAO 层
 */
@Repository(value = "BusinessDao")
public interface BusinessDao {
    /**
     * 获取所有店铺 ID
     *
     * @return List Integer 类型列表
     */
    List<Integer> getAllBusinessId();

    /**
     * 通过店铺 ID 获取店铺信息
     *
     * @param businessId 店铺 ID
     * @return BusinessInfo 实体类对象
     */
    BusinessInfo getBusinessInfoByBusinessId(@Param("businessId") Integer businessId);

    /**
     * 通过用户 ID 获取店铺信息
     *
     * @param userId 用户 ID
     * @return BusinessInfo 实体类对象
     */
    BusinessInfo getBusinessInfoByUserId(@Param("userId") Integer userId);
}
