package me.superkoh.framework.api.interceptor;

import me.superkoh.framework.api.config.RequestHeaderProperties;
import me.superkoh.framework.runtime.RuntimeEnv;
import me.superkoh.framework.security.service.LoginUserService;
import me.superkoh.framework.security.subject.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor<T extends LoginUserService> extends HandlerInterceptorAdapter {
    @Autowired
    private RuntimeEnv runtimeEnv;
    @Autowired
    private RequestHeaderProperties requestHeaderProperties;

    private LoginUserService loginUserService;

    public UserInterceptor(T loginUserService) {
        this.loginUserService = loginUserService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader(requestHeaderProperties.getUserToken());
        if (null != token) {
            LoginUser loginUser = loginUserService.getUserByToken(token);
            if (null != loginUser) {
                runtimeEnv.setLoginUser(loginUser);
            }
        }
        return true;
    }
}
