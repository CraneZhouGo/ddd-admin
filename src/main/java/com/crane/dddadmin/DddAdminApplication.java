package com.crane.dddadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableScheduling // 开启Spring自带 @Scheduled 定时任务 开关未开
public class DddAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddAdminApplication.class, args);
    }

}
