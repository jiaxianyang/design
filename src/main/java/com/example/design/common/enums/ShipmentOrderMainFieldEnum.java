package com.example.design.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ShipmentOrderMainFieldEnum简介
 * <p>
 * 单据主档查询字段枚举
 *
 * @author jiaxianyang
 * @date 2021-04-22 15:47
 */

@Getter
@AllArgsConstructor
public enum ShipmentOrderMainFieldEnum {

    /**
     * 单据主档id
     */
    ID(1, "id", "单据主档id"),

    /**
     * 仓号
     */
    WAREHOUSE_NO(2, "warehouse_no", "仓号"),

    /**
     * 单据号
     */
    ORDER_NO(3, "order_no", "单据号"),

    /**
     * 拆单次数
     */
    SPLIT_NUM(4, "split_num", "拆单次数"),

    /**
     * 发运单号
     */
    SHIPMENT_ORDER_NO(5, "shipment_order_no", "发运单号"),

    /**
     * 父发运单号
     */
    PARENT_SHIPMENT_ORDER_NO(6, "parent_shipment_order_no", "父发运单号"),

    /**
     * 单据类型
     */
    ORDER_TYPE(7, "order_type", "单据类型"),

    /**
     * 发运单类型
     */
    SHIPMENT_ORDER_TYPE(8, "shipment_order_type", "发运单类型"),

    /**
     * 来源
     */
    ORDER_SOURCE(9, "order_source", "来源"),

    /**
     * 单据总体积
     */
    TOTAL_VOLUME(10, "total_volume", "单据总体积"),

    /**
     * 单据总重量
     */
    TOTAL_WEIGHT(11, "total_weight", "单据总重量"),

    /**
     * 单据总的SKU数量
     */
    TOTAL_SKU_QTY(12, "total_sku_qty", "单据总的SKU数量"),

    /**
     * 单据总的SKU数量
     */
    TOTAL_SKU_SORT(13, "total_sku_sort", "单据总的SKU品类数"),

    /**
     * 商家单号
     */
    MERCHANT_ORDER_NO(14, "merchant_order_no", "商家单号"),

    /**
     * 收货人地址所在国家
     */
    CONSIGNEE_COUNTRY(15, "consignee_country", "收货人地址所在国家"),

    /**
     * 收货人地址所在省
     */
    CONSIGNEE_PROVINCE(16, "consignee_province", "收货人地址所在省"),

    /**
     * 收货人地址所在市
     */
    CONSIGNEE_CITY(17, "consignee_city", "收货人地址所在市"),

    /**
     * 收货人地址所在区
     */
    CONSIGNEE_REGION(18, "consignee_region", "收货人地址所在区"),

    /**
     * 收货人地址所在镇
     */
    CONSIGNEE_TOWN(19, "consignee_town", " 收货人地址所在镇"),

    /**
     * 货主编码
     */
    OWNER_NO(20, "owner_no", " 货主编码"),

    /**
     * 货主名称
     */
    OWNER_NAME(21, "owner_name", " 货主名称"),

    /**
     * 发货方编码
     */
    SHIPPER_NO(22, "shipper_no", " 发货方编码"),

    /**
     * 发货方名称
     */
    SHIPPER_NAME(23, "shipper_name", " 发货方名称"),

    /**
     * 发货方类型
     */
    SHIPPER_TYPE(24, "shipper_type", " 发货方类型"),

    /**
     * 收货方编码(门店编码,入货仓编码,网格站ID)
     */
    RECIPIENT_NO(25, "recipient_no", " 收货方编码(门店编码,入货仓编码,网格站ID)"),

    /**
     * 收货方名称(门店,团单的店铺名称,入货仓,网格站,供应商)
     */
    RECIPIENT_NAME(26, "recipient_name", "收货方名称(门店,团单的店铺名称,入货仓,网格站,供应商)"),

    /**
     * 收货方类型
     */
    RECIPIENT_TYPE(27, "recipient_type", "收货方类型"),

    /**
     * 承运商编码
     */
    CARRIER_NO(28, "carrier_no", "承运商编码"),

    /**
     * 承运商名称
     */
    CARRIER_NAME(29, "carrier_name", "承运商名称"),

    /**
     * 线路编码
     */
    ROUTE_NO(30, "route_no", "线路编码"),

    /**
     * 派车单号
     */
    SCHEDULE_BILL_CODE(31, "schedule_bill_code", "派车单号"),

    /**
     * jit下发时间
     */
    JIT_TIME(32, "jit_time", "jit下发时间"),

    /**
     * 客户下单时间
     */
    PURCHASE_TIME(33, "purchase_time", "客户下单时间"),

    /**
     * 接单时间
     */
    RECEIVE_TIME(34, "receive_time", "接单时间"),

    /**
     * 生产开始时间
     */
    PRODUCTION_BEGIN_TIME(35, "production_begin_time", "生产开始时间"),

    /**
     * 生产结束时间
     */
    PRODUCTION_END_TIME(36, "production_end_time", "生产结束时间"),

    /**
     * 流向编码
     */
    FLOW_NO(37, "flow_no", "流向编码"),

    /**
     * 流向名称
     */
    FLOW_NAME(38, "flow_name", "流向名称"),

    /**
     * sendPay
     */
    SEND_PAY(39, "send_pay", "sendPay"),

    /**
     * 是否允许缺量
     */
    SHORTAGE_FLAG(40, "shortage_flag", "是否允许缺量"),

    /**
     * 店铺编码 (门店)
     */
    SHOP_NO(41, "shop_no", "店铺编码 (门店)"),

    /**
     * 店铺名称
     */
    SHOP_NAME(42, "shop_name", "店铺名称"),

    /**
     * 最迟生产结束时间
     */
    PRODUCTION_LAST_ENDTIME(43, "production_last_endtime", "最迟生产结束时间"),

    /**
     * 收货地址
     */
    CONSIGNEE_ADDRESS(44, "consignee_address", "收货地址"),

    /**
     * 站点编号
     */
    SITE_NO(45, "site_no", "站点编号"),

    /**
     * 站点名
     */
    SITE_NAME(46, "site_name", "站点名"),

    /**
     * 单据状态
     */
    CURRENT_STATUS(47, "current_status", "单据状态"),

    /**
     * 发货方编码
     */
    WAYBILL_NO(48, "waybill_no", "运单号"),

    /**
     * 个性化生产组编码
     */
    GROUP_NO(49, "group_no", "个性化生产组编码"),

    /**
     * 发货方编码
     */
    GROUP_NAME(50, "group_name", "个性化生产组名称"),

    /**
     * 发货方编码
     */
    ORDER_CONSTRUCT(51, "order_construct", "发运单结构（单多品）待上游确认标识"),

    /**
     * 发货方编码
     */
    SALE_PLAT_FORM(52, "sale_plat_form", "商家销售平台"),


    /**
     * 目的分拣中心
     */
    DEST_SORT_CENTER(53, "dest_sort_center", "目的分拣中心"),

    /**
     * 订单子类型
     */
    ORDER_SUB_TYPE(54, "order_sub_type", "订单子类型"),

    /**
     * 退供供应商编码
     */
    RETURN_SUPPLIER_NO(55, "return_supplier_no", " 退供供应商编码"),


    /**
     * 退供供应商名称
     */
    RETURN_SUPPLIER_NAME(56, "return_supplier_name", " 退供供应商名称"),

    /**
     * 团长ID
     */
    GROUPON_HEAD_ID(57, "groupon_head_id", " 团长ID"),

    /**
     * 团单号
     */
    GROUPON_ORDER_NO(58, "groupon_order_no", " 团单号"),

    /**
     * 团单去向
     */
    DELIVERY_DESTINATION(59, "delivery_destination", " 团单去向"),

    /**
     * 团单数量
     */
    GROUP_NUM(60, "group_num", " 团单数量");

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
