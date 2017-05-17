package me.superkoh.framework.security.service;

import me.superkoh.framework.security.subject.LoginUser;
import org.hibernate.validator.constraints.NotBlank;

public interface LoginUserService {
    LoginUser getUserByToken(@NotBlank String token);
}
