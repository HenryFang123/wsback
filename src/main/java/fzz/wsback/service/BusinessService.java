package fzz.wsback.service;

import fzz.wsback.domain.BusinessInfo;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository("businessService")
public interface BusinessService {

    /**
     * get data from mysql by business id.
     *
     * @param businessId
     * @return BusinessInfo
     */
    BusinessInfo getBusinessInfoById(Integer businessId);
}
