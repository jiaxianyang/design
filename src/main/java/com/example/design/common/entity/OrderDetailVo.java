package com.example.design.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author jiaxianyang
 * @date 2024/5/14 15:46
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailVo {

    private String sku;

    private BigDecimal qty;
}
