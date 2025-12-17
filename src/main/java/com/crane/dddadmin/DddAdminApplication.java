package com.crane.dddadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DddAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddAdminApplication.class, args);
    }

}
