package com.crane.dddadmin.infrastructure.repository.trace;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * @ClassName MdcTaskDecorator
 * @Description 异步线程 MDC
 * @Author Administrator
 * @Date 2025-12-17 18:32:22
 * @Version 1.0
 **/
public class MdcTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {

        Map<String,String> context = MDC.getCopyOfContextMap();

        return () -> {
            try {
                if (context!=null){
                    MDC.setContextMap(context);
                }
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
