package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户信息（信息表）
 */
@Data
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userPassWord;
    private String userImagePath;
    private String userPhone;
    private String userEmail;
    private String userSex;
    private Integer userAge;
    private String userProvince;
    private String userCity;
    private String userRegion;
    private String userAddress;
    private Integer userTar;
}
