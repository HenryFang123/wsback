package fzz.wsback.service.impl;

import fzz.wsback.dao.UserDao;
import fzz.wsback.domain.User;
import fzz.wsback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NE
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = null;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User checkLogin(String userPhone, String userPassWord) {
        User user = userDao.getUserObjectByUserSelf(userPhone);

        if (user != null && user.getUserPassWord().equals(userPassWord)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public Integer doRegister(Integer userId, String userName, String userPassWord, String userPhone, Integer userTar) {
        try {
            userDao.registerInfoTable(userId, userName, userPassWord, userPhone, userTar);
            userDao.registerLoginTable(userId, userName, userPhone, userPassWord);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String findUserPhoneByUserId(Integer userId) {
        return userDao.getUserPhoneByUserId(userId);
    }

    @Override
    public String findUserAddressByUserId(Integer userId) {
        return userDao.getUserAddressByUserId(userId);
    }

}
