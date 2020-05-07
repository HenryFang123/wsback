package fzz.wsback.service.impl;

import fzz.wsback.dao.BusinessDao;
import fzz.wsback.domain.BusinessInfo;
import fzz.wsback.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NE
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    private final BusinessDao businessDao;

    @Autowired
    public BusinessServiceImpl(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    @Override
    public BusinessInfo getBusinessInfoById(Integer businessId) {
        return businessDao.getBusinessInfoById(businessId);
    }
}
