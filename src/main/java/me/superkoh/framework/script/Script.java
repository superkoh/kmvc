package me.superkoh.framework.script;

import me.superkoh.framework.autoconfig.profiles.ProfileConstant;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(ProfileConstant.RT_SCRIPT)
@Component
public @interface Script {
    String value() default "";
}
