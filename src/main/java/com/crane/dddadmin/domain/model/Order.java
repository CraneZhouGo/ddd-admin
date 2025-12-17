package com.crane.dddadmin.domain.model;

import java.util.UUID;

/**
 * @ClassName Crane
 * @Description TODO
 * @Author Administrator
 * @Date 2025-12-16 16:05:26
 * @Version 1.0
 **/
public class Order {
    private String id;
    private String status;


    private Order(String id, String status) {
        this.id = id;
        this.status = status;
    }


    public static Order create() {
        return new Order(UUID.randomUUID().toString(), "CREATED");
    }


    public String getId() {
        return id;
    }
}
