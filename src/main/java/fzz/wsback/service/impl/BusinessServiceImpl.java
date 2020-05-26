package fzz.wsback.service.impl;

import fzz.wsback.dao.BusinessDao;
import fzz.wsback.domain.BusinessInfo;
import fzz.wsback.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 店铺操作 SERVICE 层实现
 */
@Service(value = "businessService")
public class BusinessServiceImpl implements BusinessService {
    private final BusinessDao businessDao;

    @Autowired
    public BusinessServiceImpl(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    @Override
    public BusinessInfo getBusinessInfoByBusinessId(Integer businessId) {
        return businessDao.getBusinessInfoByBusinessId(businessId);
    }

    @Override
    public BusinessInfo getBusinessInfoByUserId(Integer userId) {
        return businessDao.getBusinessInfoByUserId(userId);
    }
}
