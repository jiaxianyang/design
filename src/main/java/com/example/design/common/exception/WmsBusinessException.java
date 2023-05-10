package com.example.design.common.exception;

public class WmsBusinessException extends RuntimeException implements IErrorCode{
    private int code;
    private String messageCode;
    private Object[] args;

    public int getCode() {
        return this.code;
    }

    public String getMessageCode() {
        return this.messageCode;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public WmsBusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public WmsBusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public WmsBusinessException(int code, String message, String messageCode, Object[] args) {
        super(message);
        this.code = code;
        this.messageCode = messageCode;
        this.args = args;
    }

    public WmsBusinessException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.messageCode = errorCode.getMessageCode();
        this.args = errorCode.getArgs();
    }
}
