package fzz.wsback.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.obs.services.ObsClient;
import fzz.wsback.dao.BookDao;
import fzz.wsback.dao.UserDao;
import fzz.wsback.service.UtilsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZZA
 * @motto Stay hungry, Stay foolish
 * @date 2020-05-26 10:48
 * @description 工具操作 SERVICE 层实现
 */
@Service(value = "UtilsService")
@Slf4j
public class UtilsServiceImpl implements UtilsService {
    /**
     * 具有访问阿里云短信权限的用户AK
     */
    private static final String ACCESS_KEY_ID_AL = "LTAI4FofXeJTbioz5BKWxNP9";
    /**
     * 具有访问阿里云短信权限的用户SK
     */
    private static final String ACCESS_KEY_SECRET_AL = "XqExGTaBgPc2K8g1Rqxnpol98uK8Zt";
    /**
     * 选择设置短信格式验证签名
     */
    private static final String SIGN_NAME = "WS商城";
    /**
     * 选择设置短信格式验证模板SMS_CODE
     */
    private static final String TEMPLATE_CODE = "SMS_186947263";

    /**
     * 具有访问华为云对象存储权限的用户AK
     */
    private static final String ACCESS_KEY_ID_HW = "OSHUUXAAJFFYUWC8KWQT";
    /**
     * 具有访问华为云对象存储权限的用户SK
     */
    private static final String ACCESS_KEY_SECRET_HW = "ngfkspJnM6zaygvHD8w1S2BLO2Q9RtONXCv2nN6j";
    /**
     * 华为云对象存储上传图片 Endpoint
     */
    private static final String END_POINT_HW = "obs.cn-north-4.myhuaweicloud.com";

    private UserDao userDao;
    private BookDao bookDao;

    @Autowired
    public UtilsServiceImpl(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @Override
    public Integer checkPhone(String userPhone) {
        Integer userId = userDao.getUserIdByUserPhone(userPhone);

        if (userId != null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Integer sendSms(String userPhone) {
        try {
            return sendCode(userPhone);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String uploadBookImage(MultipartFile multipartFile) {
        Integer nextBookId = bookDao.getLastBookId();
        String bookImagePath = "";

        ObsClient obsClient = new ObsClient(ACCESS_KEY_ID_HW, ACCESS_KEY_SECRET_HW, END_POINT_HW);

        try {
            InputStream imageInputStream = multipartFile.getInputStream();

            obsClient.putObject("netbook", "book_img/" + String.valueOf(nextBookId) + ".png", imageInputStream);

            bookImagePath = "http://image.nicezza.online/book_img/" + String.valueOf(nextBookId) + ".png";
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return bookImagePath;
    }

    /**
     * 利用阿里云 API 短信发送
     *
     * @param phoneNumber 发送短信至phoneNumber
     */
    public int sendCode(String phoneNumber) {
        // 随机设置6位手机验证码
        int phoneCode = (int) ((Math.random() * 9 + 1) * 100000);

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID_AL, ACCESS_KEY_SECRET_AL);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", TEMPLATE_CODE);
        request.putQueryParameter("TemplateParam", "{\"code\":" + phoneCode + "}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("[SendSms]--" + phoneNumber + response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return phoneCode;
    }
}
