package fzz.wsback.service.impl;

import fzz.wsback.dao.UserDao;
import fzz.wsback.service.UtilsService;
import fzz.wsback.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NE
 */
@Service("utilsService")
public class UtilsServiceImpl implements UtilsService {

    private UserDao userDao = null;

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
