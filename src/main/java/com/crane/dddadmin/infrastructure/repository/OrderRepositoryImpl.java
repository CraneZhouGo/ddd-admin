package com.crane.dddadmin.infrastructure.repository;

import com.crane.dddadmin.domain.model.Order;
import com.crane.dddadmin.domain.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @ClassName Crane
 * @Description TODO
 * @Author Administrator
 * @Date 2025-12-16 16:05:50
 * @Version 1.0
 **/
@Slf4j
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void save(Order order) {
        // TODO: 使用 MyBatis / JPA 持久化
        System.out.println("Save order: " + order.getId());
    }
}
