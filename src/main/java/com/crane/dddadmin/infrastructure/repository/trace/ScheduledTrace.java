package com.crane.dddadmin.infrastructure.repository.trace;

import java.lang.annotation.*;

/**
 * @ClassName ScheduledTrace
 * @Description 注解
 * @Author Administrator
 * @Date 2025-12-17 18:33:02
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScheduledTrace {
    String value() default "";
}
