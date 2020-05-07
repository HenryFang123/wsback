package fzz.wsback.service;

import org.springframework.stereotype.Repository;

/**
 * @author NE
 */
@Repository("utilsService")
public interface UtilsService {
    /**
     * 核查手机号是否已被使用
     *
     * @param userPhone
     * @return userId
     */
    Integer checkPhone(String userPhone);

    /**
     * 调用外挂，利用阿里云短信服务API发送短信验证信息到用户手机
     *
     * @param userPhone
     * @return phoneCode
     */
    Integer sendSms(String userPhone);
}
