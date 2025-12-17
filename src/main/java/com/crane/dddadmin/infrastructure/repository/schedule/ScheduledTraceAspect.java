package com.crane.dddadmin.infrastructure.repository.schedule;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName Crane
 * @Description 切面类 用于记录 @Scheduled 定时任务的执行日志
 * @Author Administrator
 * @Date 2025-12-17 15:49:58
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class ScheduledTraceAspect {
    @Around("@annotation(trace)")
    public Object around(ProceedingJoinPoint pjp, ScheduledTrace trace) throws Throwable {
        String traceId = "JOB-" + UUID.randomUUID().toString().replace("-", "");

        try {
            MDC.put("traceId", traceId);

            log.info("[JOB] start {} traceName={}",
                    pjp.getSignature().toShortString(),
                    trace.value());

            return pjp.proceed();
        } finally {
            log.info("[JOB] end {}",
                    pjp.getSignature().toShortString());
            MDC.clear();
        }
    }
}
