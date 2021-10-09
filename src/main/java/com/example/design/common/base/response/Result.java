package com.example.design.common.base.response;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Result简介
 *
 * @author jiaxianyang
 * @date 2021-04-24 14:11
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -7149091714996883624L;
    public static final int FAIL_CODE = 0;
    private T resultValue;
    private Integer resultCode;
    private String resultMessage;
    private String messageCode;
    private Object[] args;

    public boolean isSuccess() {
        return ResultCodeConstant.SUCCESS_CODE.equals(this.resultCode);
    }

    public static <T> Result<T> succeed(T data) {
        return (Result<T>) builder().resultValue(data).resultCode(ResultCodeConstant.SUCCESS_CODE).build();
    }

    public static <T> Result<T> succeed(T data, String message) {
        return succeed(data, message, (String)null);
    }

    public static <T> Result<T> succeed(T data, String message, String messageCode, Object... args) {
        return (Result<T>) builder().resultValue(data).resultCode(ResultCodeConstant.SUCCESS_CODE).resultMessage(message).messageCode(messageCode).args(args).build();
    }

    public static <T> Result<T> failed(String message) {
        return failed(0, message, (String)null, (Object[])null);
    }

    public static <T> Result<T> failed(String message, String messageCode, Object... args) {
        return failed(0, message, messageCode, args);
    }

    public static <T> Result<T> failed(int resultCode, String message) {
        return failed(resultCode, message, (String)null, (Object[])null);
    }

    public static <T> Result<T> failed(int resultCode, String message, String messageCode, Object... args) {
        return new Result((Object)null, resultCode, message, messageCode, args);
    }

    public static <T> Result.ResultBuilder<T> builder() {
        return new Result.ResultBuilder();
    }

    public T getResultValue() {
        return this.resultValue;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public String getMessageCode() {
        return this.messageCode;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public void setResultValue(T resultValue) {
        this.resultValue = resultValue;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Result(T resultValue, Integer resultCode, String resultMessage, String messageCode, Object[] args) {
        this.resultValue = resultValue;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.messageCode = messageCode;
        this.args = args;
    }

    public Result() {
    }

    @Override
    public String toString() {
        return "Result(resultValue=" + this.getResultValue() + ", resultCode=" + this.getResultCode() + ", resultMessage=" + this.getResultMessage() + ", messageCode=" + this.getMessageCode() + ", args=" + Arrays.deepToString(this.getArgs()) + ")";
    }

    public static class ResultBuilder<T> {
        private T resultValue;
        private Integer resultCode;
        private String resultMessage;
        private String messageCode;
        private Object[] args;

        ResultBuilder() {
        }

        public Result.ResultBuilder<T> resultValue(T resultValue) {
            this.resultValue = resultValue;
            return this;
        }

        public Result.ResultBuilder<T> resultCode(Integer resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public Result.ResultBuilder<T> resultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
            return this;
        }

        public Result.ResultBuilder<T> messageCode(String messageCode) {
            this.messageCode = messageCode;
            return this;
        }

        public Result.ResultBuilder<T> args(Object[] args) {
            this.args = args;
            return this;
        }

        public Result<T> build() {
            return new Result<T>(this.resultValue, this.resultCode, this.resultMessage, this.messageCode, this.args);
        }

        @Override
        public String toString() {
            return "Result.ResultBuilder(resultValue=" + this.resultValue + ", resultCode=" + this.resultCode + ", resultMessage=" + this.resultMessage + ", messageCode=" + this.messageCode + ", args=" + Arrays.deepToString(this.args) + ")";
        }
    }
}
