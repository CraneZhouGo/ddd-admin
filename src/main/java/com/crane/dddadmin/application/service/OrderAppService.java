package com.crane.dddadmin.application.service;

import com.crane.dddadmin.domain.model.Order;
import com.crane.dddadmin.domain.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName Crane
 * @Description TODO
 * @Author Administrator
 * @Date 2025-12-16 16:05:09
 * @Version 1.0
 **/
@Slf4j
@Service
public class OrderAppService {
    private final OrderRepository orderRepository;

    //private static final Logger log = LoggerFactory.getLogger(OrderAppService.class);

    public OrderAppService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Transactional
    public void create() {
        Order order = Order.create();
        log.info(">>> createOrder() 被调用");
        orderRepository.save(order);
    }
}
