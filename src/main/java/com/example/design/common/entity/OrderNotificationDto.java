package com.example.design.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * OrderNotificationDto简介
 *
 * 订单状态广播消息
 * @author jiaxianyang
 * @date 2021-12-22 17:16
 */
@Data
public class OrderNotificationDto implements Serializable {

    /**
     * 租户
     */
    private String tenantCode;

    /**
     * 发运单号
     */
    private String shipmentOrderNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 库房号
     */
    private String warehouseNo;

    /**
     * businessId 发送消息标识
     */
    private String businessId;

    /**
     * orderType 单据类型
     */
    private Integer orderType;

    /**
     * orderSource 订单来源
     */
    private String orderSource;

    /**
     * 生产单类型
     */
    private String shipmentOrderType;

    /**
     * sendPay
     */
    private String sendPay;

    /**
     * 货主编码
     */
    private String ownerNo;

    /**
     * jitTime jitTime
     */
    private Date jitTime;

    /**
     * carrierNo 承运商编码
     */
    private String carrierNo;

    /**
     * scheduleBillCode 派车单号
     */
    private String scheduleBillCode;

    /**
     * 团单去向
     */
    private Integer deliveryDestination;

    /**
     * uuid 防重码-单据修改使用
     */
    private String uuid;

    /**
     * 收货方编码
     */
    private String recipientNo;

    /**
     * 发货方编码
     */
    private String shipperNo;

    /**
     * 流向编码
     */
    private String flowNo;

    /**
     * 线路编码
     */
    private String routeNo;

    /**
     * 单据子类型
     */
    private Integer orderSubType;

    /**
     * 单据各个消息节点
     * @see
     */
    private Integer currentStatus;

    private OrderNotificationDto children;

}
