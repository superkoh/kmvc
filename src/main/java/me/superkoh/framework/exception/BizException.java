package me.superkoh.framework.exception;

public class BizException extends Exception {
    private int code = -1;

    public BizException() {
        super("系统错误,请稍后重试");
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
