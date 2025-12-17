package com.crane.dddadmin.infrastructure.repository.trace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduledTraceAspect
 * @Description 切面 用于记录 @Scheduled 定时任务的执行日志
 * @Author Administrator
 * @Date 2025-12-17 18:33:17
 * @Version 1.0
 **/
@Aspect
@Component
public class ScheduledTraceAspect {

    @Around("@annotation(trace)")
    public Object around(ProceedingJoinPoint pjp, ScheduledTrace trace) throws Throwable {
        String traceId = TraceIdUtil.generateJobTraceId();

        try {
            MDC.put("traceId", traceId);
            return pjp.proceed();
        } finally {
            MDC.clear();
        }
    }

}
