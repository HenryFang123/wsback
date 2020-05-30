package fzz.wsback.service.impl;

import fzz.wsback.dao.UserTypeNumberDao;
import fzz.wsback.domain.UserTypeNumber;
import fzz.wsback.service.UserTypeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 15:38
 * @description
 */
@Service(value = "UserTypeNumberService")
public class UserTypeNumberServiceImpl implements UserTypeNumberService {
    private UserTypeNumberDao userTypeNumberDao;

    @Autowired
    public UserTypeNumberServiceImpl(UserTypeNumberDao userTypeNumberDao){
        this.userTypeNumberDao = userTypeNumberDao;
    }

    @Override
    public UserTypeNumber getUserTypeNumberByUserIdAndBookTypeId(Integer userId, Integer bookTypeId) {
        return userTypeNumberDao.getUserTypeNumberByUserIdAndBookTypeId(userId, bookTypeId);
    }

    @Override
    public void insertUserTypeNumber(UserTypeNumber userTypeNumber) {
        userTypeNumberDao.insertUserTypeNumber(userTypeNumber.getUserId(), userTypeNumber.getBookTypeId(), userTypeNumber.getNumber());
    }

    @Override
    public void updateUserTypeNumber(UserTypeNumber userTypeNumber) {
        userTypeNumberDao.updateUserTypeNumber(userTypeNumber.getUserId(), userTypeNumber.getBookTypeId(), userTypeNumber.getNumber());
    }
}
