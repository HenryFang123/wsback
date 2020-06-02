package fzz.wsback.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 工具操作 SERVICE 层
 */
@Repository(value = "UtilsService")
public interface UtilsService {
    /**
     * 核查手机号是否已被使用
     *
     * @param userPhone 用户手机号
     * @return userId
     */
    Integer checkPhone(String userPhone);

    /**
     * 调用外挂，利用阿里云短信服务API发送短信验证信息到用户手机
     *
     * @param userPhone 用户手机号
     * @return phoneCode
     */
    Integer sendSms(String userPhone);

    /**
     * 上传书籍图片到华为云 OBS 桶中
     *
     * @param multipartFile
     * @return img url
     */
    String uploadBookImage(MultipartFile multipartFile);
}
