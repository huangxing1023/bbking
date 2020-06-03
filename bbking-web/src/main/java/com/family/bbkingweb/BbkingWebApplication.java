package com.family.bbkingweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = {"com.family.bbkingweb"})
@MapperScan("com.family.bbkingweb.dao.mapper.*")
@EnableScheduling
@EnableCaching
public class BbkingWebApplication {
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
    public static void main(String[] args) {
        SpringApplication.run(BbkingWebApplication.class, args);
    }

}
