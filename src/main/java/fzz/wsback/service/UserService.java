package fzz.wsback.service;

import fzz.wsback.domain.User;
import fzz.wsback.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository("userService")
public interface UserService {

    /**
     * check the user, if he wants to login system by phone and password.
     *
     * @param userPhone
     * @param userPassWord
     * @return User
     */
    User checkLogin(String userPhone, String userPassWord);

    /**
     * do register for user.
     *
     * @param userId
     * @param userName
     * @param userPassWord
     * @param userPhone
     * @param userTar
     * @return registerCode
     */
    Integer doRegister(Integer userId, String userName, String userPassWord, String userPhone, Integer userTar);

    /**
     * find user phone.
     *
     * @param userId
     * @return userPhone
     */

    String findUserPhoneByUserId(Integer userId);

    /**
     * find user address.
     *
     * @param userId
     * @return userAddress
     */

    String findUserAddressByUserId(Integer userId);

    UserInfo getUserInfoByUserPhone(String  userPhone);

    void updateUserInfo(String userPhone,String userName,String userEmail,String userSex,Integer userAge,
                        String userProvince,String userCity,String userAddress);
}
