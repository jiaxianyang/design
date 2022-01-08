package com.example.design.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * ShipmentOrderAttributeDto简介
 *
 * 发运单扩展属性
 * @author jiaxianyang
 * @date 2021-04-15 17:09
 */
@Data
public class ShipmentOrderAttributeDto implements Serializable {

    /**
     * scheduleBillSort 派车单顺序
     */
    private Integer scheduleBillSort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 路区
     */
    private String road;

    /**
     * 业务类型
     * 如内配,
     */
    private String businessType;

    /**
     * 业务子类型
     */
    private String businessSubType;

    /**
     * 目的配置中心名称
     */
    private String destinationDistributeName;

    /**
     * 目的库房名称
     */
    private String destinationWarehouseName;

    /**
     * 配送中心名称
     */
    private String distributeName;

    /**
     * 库房名称
     */
    private String warehouseName;

    /**
     * 搬仓模式 (统一取字典moveStoreType，0-任务式搬仓、1-智能搬仓)
     */
    private String moveStoreType;

    /**
     * 是否预留安全库存
     */
    private String safeStockFlag;

    /**
     * 跨配送中心
     */
    private String crossDistributeFlag;

}
