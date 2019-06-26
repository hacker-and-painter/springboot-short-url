package org.hackerandpainter;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by yongliu on 7/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShortUrlApplication.class)
@WebAppConfiguration
public class BaseTest {
}
