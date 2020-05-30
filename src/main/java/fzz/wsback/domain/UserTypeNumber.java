package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-27 15:25
 * @description 用户对类型权重
 */
@Data
public class UserTypeNumber {
    private Integer userId;
    private Integer bookTypeId;
    private Integer number;
}
