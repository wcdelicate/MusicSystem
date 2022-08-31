package com.example.musicprovider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.musicprovider.dao")
@EnableCaching
@SpringBootApplication
@EnableDubboConfiguration
public class MusicProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicProviderApplication.class, args);
    }

}
