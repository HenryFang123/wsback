package fzz.wsback.dao;

import fzz.wsback.domain.BusinessInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository("BusinessDao")
public interface BusinessDao {

    /**
     * get data from mysql by business id.
     *
     * @param businessId
     * @return BusinessInfo
     */
    BusinessInfo getBusinessInfoById(@Param("businessId") Integer businessId);
}
