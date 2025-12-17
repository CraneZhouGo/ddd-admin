package com.crane.dddadmin.infrastructure.repository.trace;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/**
 * @ClassName TraceIdFilter
 * @Description HTTP 请求 traceId
 * @Author Administrator
 * @Date 2025-12-17 18:31:34
 * @Version 1.0
 **/
@Component
public class TraceIdFilter extends OncePerRequestFilter {

    public static final String TRACE_ID_HEADER = "X-Trace-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId = Optional.ofNullable(request.getHeader(TRACE_ID_HEADER))
                .orElse(TraceIdUtil.generateHttpTraceId());

        try {
            MDC.put("traceId", traceId);
            filterChain.doFilter(request, response);
        }finally {
            MDC.clear();
        }
    }
}
