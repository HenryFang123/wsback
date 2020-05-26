package fzz.wsback.domain;

import lombok.Data;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 店铺信息
 */
@Data
public class BusinessInfo {
    private Integer businessId;
    private String businessImagePath;
    private String businessName;
    private String businessDescription;
    private Integer userId;
}
