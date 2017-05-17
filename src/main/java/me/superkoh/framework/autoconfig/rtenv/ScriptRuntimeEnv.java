package me.superkoh.framework.autoconfig.rtenv;

import me.superkoh.framework.autoconfig.profiles.ProfileConstant;
import me.superkoh.framework.runtime.RuntimeEnv;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 2017/2/5.
 * <p>
 * webFramework
 */
@Profile({ProfileConstant.RT_SCRIPT})
@Component
public class ScriptRuntimeEnv extends RuntimeEnv {
}
