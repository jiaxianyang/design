package com.example.design.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Utils简介
 *
 * @author jiaxianyang
 * @date 2022-11-01 20:38
 */
public class MD5Utils {

    private MD5Utils() {
    }

    /*
     * 为了提高安全性，我们又额外加了一串随机字符串
     */
    private static final String USER_PWD_ENCP_PREFIX = "LDHDSFHWRERHESLM";

    /**
     * 用户密码加密
     * @param beforeEncp
     * @return
     */
    public static String encode(final String beforeEncp){
        if(StringUtils.isBlank(beforeEncp)){
            return beforeEncp;
        }
        return encryptMD5(USER_PWD_ENCP_PREFIX+beforeEncp);
    }

    /**
     * md5加密
     * @param strInput
     * @return
     */
    private static String encryptMD5(final String strInput) {
        StringBuffer buf = null;
        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 输入的字符串转换成字节数组
            md.update(strInput.getBytes());
            // 转换并返回结果，也是字节数组，包含16个元素
            byte b[] = md.digest();
            // new一个StringBuffer，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
            buf = new StringBuffer(b.length * 2);
            //遍历
            for (int i = 0; i < b.length; i++) {
                if (((int) b[i] & 0xff) < 0x10) { //(int) b[i] & 0xff 转换成无符号整型
                    buf.append("0");
                }
                //Long.toHexString( 无符号长整数的十六进制字符串表示
                buf.append(Long.toHexString((int) b[i] & 0xff));
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return buf==null?null:buf.toString(); //返回加密后 的结果
    }
}
