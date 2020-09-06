package com.liangxionghua.sporthealth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.liangxionghua.sporthealth.dao")
@SpringBootApplication
public class SporthealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SporthealthApplication.class, args);
    }

}
