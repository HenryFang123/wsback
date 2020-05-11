package fzz.wsback.service;

import fzz.wsback.domain.BusinessInfo;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository(value = "businessService")
public interface BusinessService {
    /**
     * 通过店铺 ID 获取店铺信息
     *
     * @param businessId 店铺 ID
     * @return BusinessInfo
     */
    BusinessInfo getBusinessInfoByBusinessId(Integer businessId);
}
