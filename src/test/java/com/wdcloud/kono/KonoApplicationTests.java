package com.wdcloud.kono;

import org.apache.ibatis.parsing.PropertyParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class KonoApplicationTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("username","wangff");
        properties.setProperty("pwd","123456");
//        properties.setProperty(PropertyParser.KEY_ENABLE_DEFAULT_VALUE, "true");
        String rlt=PropertyParser.parse("用户名：${username} 密码：${pwd}",properties);
        System.out.println("===========>"+rlt);
    }
}
