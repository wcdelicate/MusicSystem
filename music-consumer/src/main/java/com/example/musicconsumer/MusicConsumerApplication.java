package com.example.musicconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubboConfiguration
@SpringBootApplication
public class MusicConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicConsumerApplication.class, args);
    }

}
