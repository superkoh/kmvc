package me.superkoh.framework.api.interceptor;

import me.superkoh.framework.api.annotation.GuestRequired;
import me.superkoh.framework.api.annotation.LoginRequired;
import me.superkoh.framework.exception.NeedGuestException;
import me.superkoh.framework.exception.NotLoginException;
import me.superkoh.framework.runtime.RuntimeEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RuntimeEnv runtimeEnv;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (runtimeEnv.getLoginUser().getId() < 1 || runtimeEnv.getLoginUser().getTokenExpireTime().isBefore
                (LocalDateTime.now())) {
            if (handlerMethod.getMethod().isAnnotationPresent(LoginRequired.class)) {
                throw new NotLoginException();
            }
        } else {
            if (handlerMethod.getMethod().isAnnotationPresent(GuestRequired.class)) {
                throw new NeedGuestException();
            }
        }
        return true;
    }
}
