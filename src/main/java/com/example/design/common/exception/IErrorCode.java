package com.example.design.common.exception;

import java.io.Serializable;

public interface IErrorCode extends Serializable {
    int getCode();

    String getMessage();

    String getMessageCode();

    default Object[] getArgs() {
        return null;
    }
}