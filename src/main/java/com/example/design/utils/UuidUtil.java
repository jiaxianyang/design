package com.example.design.utils;

import java.util.UUID;

public class UuidUtil {
    /**
     * 获取原始UUID，中间会有-
     * 4c72eb3e-675f-4a00-b806-4c37c6474cc7
     *
     * @return
     */
    public static String getOriginalUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取去掉-符号的小写字母UUID
     * 4c72eb3e675f4a00b8064c37c6474cc7
     *
     * @return
     */
    public static String getUuid() {
        return getOriginalUuid().replace("-", "").toLowerCase();
    }
}
