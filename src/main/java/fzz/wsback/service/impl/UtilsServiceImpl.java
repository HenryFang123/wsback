package fzz.wsback.service.impl;

import fzz.wsback.dao.UserDao;
import fzz.wsback.service.UtilsService;
import fzz.wsback.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 工具操作 SERVICE 层实现
 */
@Service(value = "UtilsService")
public class UtilsServiceImpl implements UtilsService {
    private final UserDao userDao;

    @Autowired
    public UtilsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Integer checkPhone(String userPhone) {
        Integer userId = userDao.getUserIdByUserPhone(userPhone);

        if (userId != null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Integer sendSms(String userPhone) {
        try {
            SmsUtils.sendCode(userPhone);
            return SmsUtils.phoneCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
