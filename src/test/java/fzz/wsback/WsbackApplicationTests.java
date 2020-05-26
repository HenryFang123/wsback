package fzz.wsback;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import fzz.wsback.domain.UserInfo;
import fzz.wsback.service.UserService;
import fzz.wsback.utils.SmsUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WsbackApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSms() {
        String number = "17852323581";
        SmsUtils.sendCode(number);
    }

    @Test
    @JunitPerfConfig(threads = 50, warmUp = 1_000, duration = 30_000,
            reporter = {HtmlReporter.class, ConsoleReporter.class})
    public void testGetUserInfoByUserId() {
        UserInfo userInfo = userService.getUserInfoByUserId(403143715);
    }
}
