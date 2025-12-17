package com.crane.dddadmin.infrastructure.repository.trace;

import java.util.UUID;

/**
 * @ClassName TraceIdUtil
 * @Description traceId 生成器
 * @Author Administrator
 * @Date 2025-12-17 18:33:34
 * @Version 1.0
 **/
public class TraceIdUtil {
    public static String generateHttpTraceId() {
        return "HTTP-" + UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateJobTraceId() {
        return "JOB-" + UUID.randomUUID().toString().replace("-", "");
    }

    /*public static String generateMqTraceId() {
        return "MQ-" + UUID.randomUUID().toString().replace("-", "");
    }*/
}
