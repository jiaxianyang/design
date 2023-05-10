package com.example.design.log;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OperationLogUtil简介
 *
 * 记录方法的调用日志
 * @author jiaxianyang
 * @date 2023-01-05 15:27
 */
@UtilityClass
public class OperationLogUtil {

    /**
     * 操作日志Logger
     */
    private static final Logger OPERATION = LoggerFactory.getLogger("operation");

    public void info(String info) {
        if (OPERATION.isInfoEnabled()) {
            OPERATION.info(info);
        }
    }
}
