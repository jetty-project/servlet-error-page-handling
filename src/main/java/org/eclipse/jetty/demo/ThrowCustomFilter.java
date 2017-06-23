package org.eclipse.jetty.demo;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/filter-thrown-custom/*", dispatcherTypes = DispatcherType.REQUEST, asyncSupported = true)
public class ThrowCustomFilter implements Filter
{
    private static final Logger LOG = Logger.getLogger(ThrowCustomFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        throw new CustomException("From Filter");
    }

    @Override
    public void destroy()
    {
    }
}
