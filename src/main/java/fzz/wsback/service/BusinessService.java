package fzz.wsback.service;

import fzz.wsback.domain.BusinessInfo;
import org.springframework.stereotype.Repository;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 店铺操作 SERVICE 层
 */
@Repository(value = "BusinessService")
public interface BusinessService {
    /**
     * 通过店铺 ID 获取店铺信息
     *
     * @param businessId 店铺 ID
     * @return BusinessInfo
     */
    BusinessInfo getBusinessInfoByBusinessId(Integer businessId);

    /**
     * 通过用户 ID 获取店铺信息
     *
     * @param userId 用户 ID
     * @return BusinessInfo 实体类对象
     */
    BusinessInfo getBusinessInfoByUserId(Integer userId);
}
