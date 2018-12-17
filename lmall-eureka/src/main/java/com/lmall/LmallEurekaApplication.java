package com.lmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
@EnableEurekaServer
public class LmallEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmallEurekaApplication.class, args);
    }
}
