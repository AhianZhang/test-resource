
package com.ahianzhang.xp.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoad() {
        DemoApplication.main(new String[] {});
    }
}
