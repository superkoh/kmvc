package me.superkoh.framework.api;

import me.superkoh.framework.autoconfig.rtenv.WebRuntimeEnv;
import me.superkoh.framework.runtime.RuntimeEnv;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KOH on 2017/2/7.
 * <p>
 * webFramework
 */
abstract public class BaseApi {
    @Autowired
    private RuntimeEnv runtimeEnv;

    protected WebRuntimeEnv getEnv() {
        return (WebRuntimeEnv) runtimeEnv;
    }
}
