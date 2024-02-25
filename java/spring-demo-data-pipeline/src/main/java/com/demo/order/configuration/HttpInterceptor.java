package com.demo.order.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Http interceptor.
 */
public final class HttpInterceptor implements HandlerInterceptor {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpInterceptor.class);

    /**
     * Pre handle boolean.
     *
     * @param request  the request
     * @param response the response
     * @param handler  the handler
     * @return the boolean
     */
    @Override
    public boolean preHandle(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final Object handler) {
        try {
            return HandlerInterceptor.super.preHandle(request,
                    response,
                    handler);
        } catch (Exception e) {
            LOGGER.error("pre handler send error",
                    e);
        }
        return false;
    }

    /**
     * After completion.
     *
     * @param request  the request
     * @param response the response
     * @param handler  the handler
     * @param ex       the ex
     */
    @Override
    public void afterCompletion(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final Object handler,
            final Exception ex) {
        try {
            HandlerInterceptor.super.afterCompletion(request,
                    response,
                    handler,
                    ex);
        } catch (Exception e) {
            LOGGER.error("Request completion error",
                    e);
        }
    }

}
