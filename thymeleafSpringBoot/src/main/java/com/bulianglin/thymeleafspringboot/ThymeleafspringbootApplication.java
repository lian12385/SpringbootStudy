package com.bulianglin.thymeleafspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan(basePackages = "com.bulianglin.thymeleafspringboot")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class ThymeleafspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafspringbootApplication.class, args);
    }

}
