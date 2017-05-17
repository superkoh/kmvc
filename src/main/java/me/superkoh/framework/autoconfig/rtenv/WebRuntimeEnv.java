package me.superkoh.framework.autoconfig.rtenv;

import me.superkoh.framework.autoconfig.profiles.ProfileConstant;
import me.superkoh.framework.runtime.RuntimeEnv;
import me.superkoh.framework.security.subject.GuestUser;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

@Profile(ProfileConstant.RT_WEB)
@Component("webRuntimeEnv")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebRuntimeEnv extends RuntimeEnv {
    private ConcurrentHashMap<String, Object> state = new ConcurrentHashMap<>();
    private String userAgent;
    private String remoteIp;

    public WebRuntimeEnv() {
        this.setLoginUser(new GuestUser());
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public Object getState(String key) {
        return state.get(key);
    }

    public void setState(String key, Object value) {
        state.put(key, value);
    }
}
