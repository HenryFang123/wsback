package fzz.wsback.dao;

import fzz.wsback.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository("UserDao")
public interface UserDao {

    /**
     * find data in mysql by userPhone.
     *
     * @param userPhone
     * @return User
     */
    User getUserObjectByUserSelf(@Param("userPhone") String userPhone);

    /**
     * find userId in mysql by userPhone.
     *
     * @param userPhone
     * @return userId
     */
    Integer getUserIdByUserPhone(@Param("userPhone") String userPhone);

    /**
     * find userPhone in mysql by userId.
     *
     * @param userId
     * @return userPhone
     */
    String getUserPhoneByUserId(@Param("userId") Integer userId);

    /**
     * find userAddress in mysql by userId.
     *
     * @param userId
     * @return userAddress
     */
    String getUserAddressByUserId(@Param("userId") Integer userId);

    /**
     * register user by the data from front.
     *
     * @param userId
     * @param userName
     * @param userPassWord
     * @param userPhone
     * @param userTar
     */
    void registerInfoTable(@Param("userId") Integer userId, @Param("userName") String userName, @Param("userPassWord") String userPassWord, @Param("userPhone") String userPhone, @Param("userTar") Integer userTar);

    /**
     * register user by the data from front.
     *
     * @param userId
     * @param userName
     * @param userPassWord
     * @param userPhone
     */
    void registerLoginTable(@Param("userId") Integer userId, @Param("userName") String userName, @Param("userPhone") String userPhone, @Param("userPassWord") String userPassWord);

}
