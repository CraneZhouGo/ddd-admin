package com.crane.dddadmin.domain.repository;

import com.crane.dddadmin.domain.model.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Crane
 * @Description TODO
 * @Author Administrator
 * @Date 2025-12-16 16:05:36
 * @Version 1.0
 **/
public interface OrderRepository {
    void save(Order order);
}
