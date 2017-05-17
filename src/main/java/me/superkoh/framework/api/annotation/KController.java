package me.superkoh.framework.api.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * Created by KOH on 2017/5/17.
 * <p>
 * kmvc
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface KController {
}
