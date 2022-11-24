package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/demo/**")
@Component
public class RequestFilter implements Filter {

    final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session =servletRequest.getSession();

        String requestPath = servletRequest.getRequestURI();

        if(needsAuthentication(requestPath)) {
            logger.info(requestPath);
        }
        else {
            logger.info(requestPath);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private boolean needsAuthentication(String url) {
        String[] validNonAuthenticationUrls =
                { "Login.jsp", "Register.jsp" };
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
}
