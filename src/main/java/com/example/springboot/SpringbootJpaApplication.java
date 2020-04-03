package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling//由于SpringBoot内置了定时任务Scheduled，能够很好的实现定时任务。
@ComponentScan(basePackages = "com.example")
public class SpringbootJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }
}
