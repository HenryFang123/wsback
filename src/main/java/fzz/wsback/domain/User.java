package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户信息（登录表）
 */
@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPassWord;
    private String userPhone;
    private String userEmail;
    private Integer userAge;
    private Integer userTar;
}
