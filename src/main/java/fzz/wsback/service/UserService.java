package fzz.wsback.service;

import fzz.wsback.domain.User;
import fzz.wsback.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NE
 */
@Repository(value = "userService")
public interface UserService {
    /**
     * 登录检查
     *
     * @param userPhone 用户手机号
     * @param userPassWord 用户密码
     * @return User 实体类对象
     */
    User checkLogin(String userPhone,
                    String userPassWord);

    /**
     * 注册用户
     *
     * @param userId 用户 ID
     * @param userName 用户名
     * @param userPassWord 用户密码
     * @param userPhone 用户手机号
     * @param userTar 用户标识
     * @return registerCode 注册成功码
     */
    Integer doRegister(Integer userId,
                       String userName,
                       String userPassWord,
                       String userPhone,
                       Integer userTar);

    /**
     * 通过用户手机号获取用户信息
     *
     * @param userPhone 用户手机号
     * @return UserInfo 实体类对象
     */
    UserInfo getUserInfoByUserPhone(String  userPhone);

    /**
     * 通过用户 ID 获取用户手机号
     *
     * @param userId 用户 ID
     * @return userPhone 用户手机号
     */
    String getUserPhoneByUserId(Integer userId);

    /**
     * 通过用户 ID 获取用户收货地址
     *
     * @param userId 用户手机号
     * @return userAddress 用户收货地址
     */
    String getUserAddressByUserId(Integer userId);

    /**
     * 通过用户 ID 获取用户信息
     *
     * @param userId 用户 ID
     * @return userInfo 实体类对象
     */
    UserInfo getUserInfoByUserId(Integer userId);

    /**
     * 更新用户信息
     *
     * @param userPhone 用户手机号
     * @param userName 用户名
     * @param userEmail 用户邮箱地址
     * @param userSex 用户性别
     * @param userAge 用户年龄
     * @param userProvince 用户省份
     * @param userCity 用户城市居住地
     * @param userRegion 用户所在区
     * @param userAddress 用户收货地址
     */
    void updateUserInfo(String userPhone,
                        String userName,
                        String userEmail,
                        String userSex,
                        Integer userAge,
                        String userProvince,
                        String userCity,
                        String userRegion,
                        String userAddress);
}
