package me.superkoh.framework.security.subject;

import java.time.LocalDateTime;

/**
 * Created by KOH on 16/8/4.
 */
public interface LoginUser {
    Long getId();

    String getUsername();

    String getToken();

    LocalDateTime getTokenExpireTime();
}
