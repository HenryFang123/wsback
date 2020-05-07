package fzz.wsback.domain;

/**
 * @author NE
 */
public class BusinessInfo {

    private Integer businessId;
    private String businessImagePath;
    private String businessName;
    private String businessDescription;
    private Integer userId;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessImagePath() {
        return businessImagePath;
    }

    public void setBusinessImagePath(String businessImagePath) {
        this.businessImagePath = businessImagePath;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
