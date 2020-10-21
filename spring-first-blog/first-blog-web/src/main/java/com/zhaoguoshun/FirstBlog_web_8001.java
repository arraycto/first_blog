package com.zhaoguoshun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //自动向服务端注册
public class FirstBlog_web_8001 {

    public static void main(String[] args) {
        SpringApplication.run(FirstBlog_web_8001.class,args);
    }
}
