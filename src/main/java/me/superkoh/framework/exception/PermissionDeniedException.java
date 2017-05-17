package me.superkoh.framework.exception;

public class PermissionDeniedException extends BizRuntimeException {
    public PermissionDeniedException() {
        super("permission denied!");
    }
}
