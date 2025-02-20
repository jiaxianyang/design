package com.example.design.utils.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangdianzhuang
 * @date 2023/10/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UmpConfVo {
    /**
     * 业务名
     */
    private String businessName;
    /**
     * umpKey
     */
    private String umpKey;
}
