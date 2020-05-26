package fzz.wsback.dao;

import fzz.wsback.domain.User;
import fzz.wsback.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户操作 DAO 层
 */
@Repository(value = "UserDao")
public interface UserDao {
    /**
     * 通过用户手机号获取用户信息
     *
     * @param userPhone 用户手机号
     * @return User
     */
    User getUserInfoByUserSelf(@Param("userPhone") String userPhone);

    /**
     * 通过用户手机号获取用户 ID
     *
     * @param userPhone 用户手机号
     * @return userId
     */
    Integer getUserIdByUserPhone(@Param("userPhone") String userPhone);

    /**
     * 通过用户手机号获取用户信息
     *
     * @param userPhone 用户手机号
     * @return UserInfo 实体类对象
     */
    UserInfo getUserInfoByUserPhone(@Param("userPhone")String userPhone);

    /**
     * 通过用户 ID 获取用户手机号
     *
     * @param userId 用户 ID
     * @return userPhone
     */
    String getUserPhoneByUserId(@Param("userId") Integer userId);

    /**
     * 通过用户 ID 获取用户收货地址
     *
     * @param userId 用户 ID
     * @return userAddress
     */
    String getUserAddressByUserId(@Param("userId") Integer userId);

    /**
     * 通过用户 ID 获取用户信息
     *
     * @param userId 用户 ID
     * @return userInfo 实体类对象
     */
    UserInfo getUserInfoByUserId(@Param("userId") Integer userId);

    /**
     * 注册用户并填写信息到用户信息表
     *
     * @param userId 用户 ID
     * @param userName 用户名
     * @param userPassWord 用户密码
     * @param userPhone 用户手机号
     * @param userTar 用户标识
     */
    void registerInfoTable(@Param("userId") Integer userId,
                           @Param("userName") String userName,
                           @Param("userPassWord") String userPassWord,
                           @Param("userPhone") String userPhone,
                           @Param("userTar") Integer userTar);

    /**
     * 注册用户并填写信息到用户登录表
     *
     * @param userId 用户 ID
     * @param userName 用户名
     * @param userPassWord 用户密码
     * @param userPhone 用户手机号
     */
    void registerLoginTable(@Param("userId") Integer userId,
                            @Param("userName") String userName,
                            @Param("userPhone") String userPhone,
                            @Param("userPassWord") String userPassWord);

    /**
     * 更新用户信息
     *
     * @param userImagePath 用户头像
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
    void updateUserInfo(@Param("userImagePath") String userImagePath,
                        @Param("userPhone") String userPhone,
                        @Param("userName") String userName,
                        @Param("userEmail") String userEmail,
                        @Param("userSex") String userSex,
                        @Param("userAge") Integer userAge,
                        @Param("userProvince") String userProvince,
                        @Param("userCity") String userCity,
                        @Param("userRegion") String userRegion,
                        @Param("userAddress") String userAddress);
}
