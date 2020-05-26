package fzz.wsback.service.impl;

import fzz.wsback.dao.UserDao;
import fzz.wsback.domain.User;
import fzz.wsback.domain.UserInfo;
import fzz.wsback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户操作 SERVICE 层实现
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao = null;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User checkLogin(String userPhone, String userPassWord) {
        User user = userDao.getUserInfoByUserSelf(userPhone);

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
    public UserInfo getUserInfoByUserPhone(String userPhone) {
        return userDao.getUserInfoByUserPhone(userPhone);
    }

    @Override
    public String getUserPhoneByUserId(Integer userId) {
        return userDao.getUserPhoneByUserId(userId);
    }

    @Override
    public String getUserAddressByUserId(Integer userId) {
        return userDao.getUserAddressByUserId(userId);
    }

    @Override
    public UserInfo getUserInfoByUserId(Integer userId) {
        return userDao.getUserInfoByUserId(userId);
    }

    @Override
    public void updateUserInfo(String userImagePath, String userPhone, String userName, String userEmail, String userSex, Integer userAge, String userProvince, String userCity,String userRegion, String userAddress) {
        userDao.updateUserInfo(userImagePath, userPhone,userName,userEmail,userSex,userAge,userProvince,userCity,userRegion,userAddress);
    }

}
