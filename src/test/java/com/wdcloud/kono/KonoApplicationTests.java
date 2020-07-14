package com.wdcloud.kono;

import org.apache.ibatis.parsing.PropertyParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class KonoApplicationTests {

    @Test
    void contextLoads() {
        Properties properties = new Properties();
        properties.setProperty("username","123");
        String rlt=PropertyParser.parse("${username:root}",properties);
        System.out.println("===========>"+rlt);
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("username","123");
        String rlt=PropertyParser.parse("username",properties);
        System.out.println("===========>"+rlt);
    }
}
