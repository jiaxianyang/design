package com.example.design.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ShipmentOrderInfoDetailFieldEnum简介
 * <p>
 * 单据详情查询字段枚举
 *
 * @author jiaxianyang
 * @date 2021-04-22 15:46
 */

@Getter
@AllArgsConstructor
public enum ShipmentOrderInfoDetailFieldEnum {

    /**
     * 单据详情id
     */
    ID(1, "id", "单据详情id"),

    /**
     * 单据主档ID
     */
    SHIPMENT_ORDER_ID(2, "shipment_order_id", "单据主档ID"),

    /**
     * 库房编码
     */
    WAREHOUSE_NO(3, "warehouse_no", "库房编码"),

    /**
     * 订单号
     */
    ORDER_NO(4, "order_no", "订单号"),

    /**
     * 订单来源
     */
    ORDER_SOURCE(5, "order_source", "订单来源"),

    /**
     * 发运单号
     */
    SHIPMENT_ORDER_NO(6, "shipment_order_no", "发运单号"),

    /**
     * 发运单明细行号
     */
    ORDER_LINE_NO(7, "order_line_no", "发运单明细行号"),

    /**
     * 商品编码
     */
    SKU(8, "sku", "商品编码"),


    /**
     * 商品编码
     */
    SKU_NAME(9, "sku_name", "商品名称"),

    /**
     * 货主编码
     */
    OWNER_NO(10, "owner_no", "货主编码"),

    /**
     * 货主名称
     */
    OWNER_NAME(11, "owner_name", "货主名称"),

    /**
     * 商品数量
     */
    SKU_QTY(12, "sku_qty", "商品数量"),

    /**
     * 商品等级
     */
    SKU_LEVEL(13, "sku_level", "商品等级"),

    /**
     * 商品体积
     */
    SKU_VOLUME(14, "sku_volume", "商品体积"),

    /**
     * 商品重量
     */
    SKU_WEIGHT(15, "sku_weight", "商品重量"),

    /**
     * 批属性列表
     */
    BATCH_ATTRIBUTE(16, "batch_attribute", "批属性列表"),

    /**
     * 批次编码
     */
    LOT_NO(17, "lot_no", "批次编码"),

    /**
     * 批次编码
     */
    IRREGULAR_FLAG(18, "irregular_flag", "不规则标识"),

    /**
     * 批次编码
     */
    SERIAL_TYPE(19, "serial_type", "序列号管理方式(0非序列号管理；1序列号管理；2序列号全流程管理；3件轻量级序列号；4箱轻量级序列号；5箱件混采轻量级序列号)");

    /**
     * 编号
     */
    private int code;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段描述
     */
    private String fieldDesc;
}
