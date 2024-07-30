package com.Tancem.PIS.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    private static final Set<String> SENSITIVE_HEADERS = new HashSet<>(Arrays.asList("authorization", "cookie"));

    @Override
    public void init(FilterConfig filterConfig) {
        // Initialization logic, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        logRequest(httpServletRequest);
        chain.doFilter(request, response);
        logResponse(httpServletResponse);
    }

    private void logRequest(HttpServletRequest request) {
        logger.debug("Request Method: {}", request.getMethod());
        logger.debug("Request URI: {}", request.getRequestURI());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            if (!SENSITIVE_HEADERS.contains(headerName.toLowerCase())) {
                logger.debug("Request Header: {} = {}", headerName, request.getHeader(headerName));
            }
        }
    }

    private void logResponse(HttpServletResponse response) {
        logger.debug("Response Status: {}", response.getStatus());
        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            if (!SENSITIVE_HEADERS.contains(headerName.toLowerCase())) {
                logger.debug("Response Header: {} = {}", headerName, response.getHeader(headerName));
            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic, if needed
    }
}
