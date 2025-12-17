package com.crane.dddadmin.infrastructure.repository.schedule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Crane
 * @Description 定义注解
 * @Author Administrator
 * @Date 2025-12-17 15:47:39
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScheduledTrace {
    String value() default "";
}
