package com.example.design.utils.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangdianzhuang
 * @date 2023/10/27
 */
@Data
@NoArgsConstructor
public class MdcConfVo {
    /**
     * 系统编码
     */
    private String sysCode;
    /**
     * 应用编码
     */
    private String appCode;
    /**
     * 系统名称
     */
    private String appName;
    /**
     * 分组编码
     */
    private String groupCode;

    public MdcConfVo(String sysCode, String appCode, String appName) {
        this.sysCode = sysCode;
        this.appCode = appCode;
        this.appName = appName;
    }
}
