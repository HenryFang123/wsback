package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 用户收藏信息
 */
@Data
public class UserStar {
    private Integer userId;
    private Integer userStarId;
    private Integer userStarTag;
    private Integer userStarStatus;
}
