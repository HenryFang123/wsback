package fzz.wsback;

import fzz.wsback.utils.SmsUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WsbackApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testSms(){
        String number = "17852323581";
        SmsUtils.sendCode(number);
    }

}
