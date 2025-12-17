package com.crane.dddadmin.interfaces.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName Crane
 * @Description 全链路日志加上标记 traceId
 * @Author Administrator
 * @Date 2025-12-17 12:21:36
 * @Version 1.0
 **/
@Component
public class TraceIdFilter extends OncePerRequestFilter {

    public static final String TRACE_ID = "traceId";
    public static final String HEADER_TRACE_ID = "X-Trace-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1、如果上游传了traceId(网关/前端)，就用它
        String traceId = request.getHeader(HEADER_TRACE_ID);
        if (traceId == null || traceId.isEmpty()) {
            //2、如果上游没有传traceId，就生成一个
            traceId = UUID.randomUUID().toString().replace("-", "");
        }

        try {
            //3、放入MDC
            MDC.put(TRACE_ID,traceId);
            //4、回写给前端（方便排查）
            response.setHeader(HEADER_TRACE_ID, traceId);

            filterChain.doFilter(request, response);
        }finally {
            //5、必须清理（防止线程复用污染）
            MDC.remove(TRACE_ID);
        }
    }
}
