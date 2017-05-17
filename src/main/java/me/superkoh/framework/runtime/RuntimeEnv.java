package me.superkoh.framework.runtime;

import me.superkoh.framework.security.subject.LoginUser;
import me.superkoh.framework.security.subject.SystemUser;

public class RuntimeEnv {
    private LoginUser loginUser;

    public RuntimeEnv() {
        this.loginUser = new SystemUser();
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }
}
