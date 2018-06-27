package com.ljf.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * log Filter
 */
public class LogFilter implements Filter {

    private static final Logger log = Logger.getLogger(LogFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest)servletRequest).getRequestURI();
        log.debug("request url: " + url);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
