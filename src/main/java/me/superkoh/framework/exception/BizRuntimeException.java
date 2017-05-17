package me.superkoh.framework.exception;

/**
 * Created by KOH on 2017/2/5.
 * <p>
 * webFramework
 */
public class BizRuntimeException extends RuntimeException {
    private int code = -1;

    public BizRuntimeException() {
        super("系统错误,请稍后重试");
    }

    public BizRuntimeException(String message) {
        super(message);
    }

    public BizRuntimeException(int code, String message) {
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
