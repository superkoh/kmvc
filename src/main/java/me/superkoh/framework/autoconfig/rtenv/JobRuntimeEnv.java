package me.superkoh.framework.autoconfig.rtenv;

import me.superkoh.framework.autoconfig.profiles.ProfileConstant;
import me.superkoh.framework.runtime.RuntimeEnv;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ProfileConstant.RT_JOB})
@Component
public class JobRuntimeEnv extends RuntimeEnv {
}
