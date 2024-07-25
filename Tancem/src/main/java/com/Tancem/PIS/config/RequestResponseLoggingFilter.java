package com.Tancem.PIS.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.Filter;
import java.io.IOException;
import java.util.Collections;

@Component
public class RequestResponseLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if any
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
        logger.debug("Request Headers: {}", Collections.list(request.getHeaderNames()));
    }

    private void logResponse(HttpServletResponse response) {
        logger.debug("Response Status: {}", response.getStatus());
        logger.debug("Response Headers: {}", response.getHeaderNames());
    }

    @Override
    public void destroy() {
        // Cleanup logic, if any
    }
}
