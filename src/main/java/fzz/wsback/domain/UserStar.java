package fzz.wsback.domain;

/**
 * @author NE
 */
public class UserStar {
    private Integer userId;
    private Integer userStarId;
    private Integer userStarTag;
    private Integer userStarStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserStarId() {
        return userStarId;
    }

    public void setUserStarId(Integer userStarId) {
        this.userStarId = userStarId;
    }

    public Integer getUserStarTag() {
        return userStarTag;
    }

    public void setUserStarTag(Integer userStarTag) {
        this.userStarTag = userStarTag;
    }

    public Integer getUserStarStatus() {
        return userStarStatus;
    }

    public void setUserStarStatus(Integer userStarStatus) {
        this.userStarStatus = userStarStatus;
    }
}
