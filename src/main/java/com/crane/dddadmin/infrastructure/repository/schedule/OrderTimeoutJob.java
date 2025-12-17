package com.crane.dddadmin.infrastructure.repository.schedule;

import com.crane.dddadmin.application.service.OrderAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName Crane
 * @Description spring 自带job @Scheduled 执行自动任务
 * @Author Administrator
 * @Date 2025-12-17 15:56:19
 * @Version 1.0
 **/
@Slf4j
@Component
public class OrderTimeoutJob {
    private final OrderAppService orderAppService;

    public OrderTimeoutJob(OrderAppService orderAppService) {
        this.orderAppService = orderAppService;
    }

    //每10s执行一次
    @Scheduled(cron = "0/10 * * * * ?")
    @ScheduledTrace("order-timeout-check")
    public void execute() {
        log.info("[JOB] trigger order timeout check");
        orderAppService.checkTimeoutOrders();
    }
}
