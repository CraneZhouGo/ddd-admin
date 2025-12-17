package com.crane.dddadmin.infrastructure.repository.trace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @ClassName AsyncConfig
 * @Description 线程池配置
 * @Author Administrator
 * @Date 2025-12-17 18:32:43
 * @Version 1.0
 **/
@Configuration
public class AsyncConfig {
    @Bean
    public ThreadPoolTaskExecutor applicationExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(1000);
        executor.setTaskDecorator(new MdcTaskDecorator());
        executor.initialize();
        return executor;
    }
}
