package me.superkoh.framework.exception;

public class NotLoginException extends BizRuntimeException {
    public NotLoginException() {
        super(4031, "not login");
    }
}
