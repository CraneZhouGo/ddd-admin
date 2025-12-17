package com.crane.dddadmin.interfaces.web;

import com.crane.dddadmin.application.service.OrderAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName Crane
 * @Description TODO
 * @Author Administrator
 * @Date 2025-12-16 16:05:00
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderAppService orderAppService;


    public OrderController(OrderAppService orderAppService) {
        this.orderAppService = orderAppService;
    }


    @PostMapping
    public void createOrder() {
        orderAppService.create();
    }
}
