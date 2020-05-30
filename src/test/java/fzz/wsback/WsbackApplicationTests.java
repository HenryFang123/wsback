package fzz.wsback;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import fzz.wsback.domain.UserInfo;
import fzz.wsback.service.RecommendService;
import fzz.wsback.service.UserService;
import fzz.wsback.service.impl.RecommendServiceImpl;
import fzz.wsback.utils.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class WsbackApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    RecommendServiceImpl recommendServiceImpl;

    @Test
    void contextLoads() {
    }

    @Test
    @JunitPerfConfig(threads = 50, warmUp = 1_000, duration = 30_000,
            reporter = {HtmlReporter.class, ConsoleReporter.class})
    public void testGetUserInfoByUserId() {
        UserInfo userInfo = userService.getUserInfoByUserId(403143715);
    }

    @Test
    public void testDoRecommendMahout(){
        recommendServiceImpl.doRecommendMahout();
    }

    @Test
    public void testDoRecommendToSaveUserTypes(){
        recommendServiceImpl.doRecommendToSaveUserTypes();
    }

    @Test
    public void testDoRecommendSystem(){
        recommendServiceImpl.doRecommendSystem();
    }

    @Test
    public void testDoRecommendBusiness(){
        recommendServiceImpl.doRecommendBusiness();
    }
}
