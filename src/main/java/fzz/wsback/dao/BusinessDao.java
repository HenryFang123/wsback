package fzz.wsback.dao;

import fzz.wsback.domain.BusinessInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository(value = "BusinessDao")
public interface BusinessDao {
    /**
     * 通过店铺 ID 获取店铺信息
     *
     * @param businessId 店铺 ID
     * @return BusinessInfo 实体类对象
     */
    BusinessInfo getBusinessInfoByBusinessId(@Param("businessId") Integer businessId);
}
