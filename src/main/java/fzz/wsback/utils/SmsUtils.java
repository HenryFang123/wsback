package fzz.wsback.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author NE
 */
public class SmsUtils {
    /**
     * 具有访问权限的用户AK
     */
    private static final String ACCESS_KEY_ID = "LTAI4FofXeJTbioz5BKWxNP9";
    /**
     * 具有访问权限的用户SK
     */
    private static final String ACCESS_KEY_SECRET = "XqExGTaBgPc2K8g1Rqxnpol98uK8Zt";
    /**
     * 选择设置短信格式验证签名
     */
    private static final String SIGN_NAME = "WS商城";
    /**
     * 选择设置短信格式验证模板SMS_CODE
     */
    private static final String TEMPLATE_CODE = "SMS_186947263";
    /**
     * 随机设置6位手机验证码
     */
    public static int phoneCode = (int) ((Math.random() * 9 + 1) * 100000);

    /**
     * 利用阿里云 API 短信发送
     *
     * @param phoneNumber 发送短信至phoneNumber
     */
    public static void sendCode(String phoneNumber) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
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
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
