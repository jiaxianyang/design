package com.example.design.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * OrderNodeMsgEnum简介
 * <p>
 * 节点消息枚举
 *
 * @author jiaxianyang
 * @date 2021-04-22 11:25
 */

@AllArgsConstructor
@Getter
public enum OrderNodeMsgEnum {


    /**
     * 订单明细修改-不属于订单状态
     */
    DETAIL_MODIFIED(2, "订单明细修改"),

    /**
     * shipmentOrderType改变  计划初始化完成
     */
    PLAN_INITIALIZED(1, "计划初始化完成"),

    /**
     * 初始化完成
     */
    INITIALIZED(0, "已接单"),

    /**
     * 定位完成
     */
    LOCATED(10, "已定位"),

    /**
     * 任务分配完成
     */
    TASK_ALLOCATED(30, "已任务分配"),

    /**
     * 拣货完成
     */
    PICKED(40, "已拣货"),

    /**
     * 复核完成
     */
    CHECKED(50, "已复核"),

    /**
     * 打包完成
     */
    PACKAGED(60, "已打包"),

    /**
     * 发货完成
     */
    DELIVERED(70, "已发货"),

    /**
     * 拉回
     */
    PULL_BACK(80, "已拉回"),

    /**
     * 取消完成
     */
    CANCELED(90, "已取消"),

    /**
     * 零定位出库完成
     */
    ZERO_LOCATED(12, "已零定位出库"),

    /**
     * 零拣货出库完成
     */
    ZERO_PICKED(42, "已零拣货出库"),

    /**
     * 零复核出库完成
     */
    ZERO_CHECKED(52, "已零复核出库"),

    RESTART(120, "已重新生产");

    /**
     * 节点类型
     */
    private final int nodeType;

    /**
     * 节点描述
     */
    private final String nodeDesc;


    /**
     * 根据节点类型获取节点消息枚举
     *
     * @param nodeType 节点状态
     * @return OrderNodeMsgEnum
     */
    public static OrderNodeMsgEnum getOrderNodeMsgEnumByType(Integer nodeType) {
        if (Objects.isNull(nodeType)) {
            return null;
        }
        return Arrays.stream(OrderNodeMsgEnum.values()).filter(value -> value.getNodeType() == nodeType)
                .findFirst().orElse(null);
    }

    public static void main(String[] args) {
        Optional<OrderNodeMsgEnum> optionalOrderNodeMsgEnum = Arrays.stream(OrderNodeMsgEnum.values()).filter(orderNodeMsgEnum -> orderNodeMsgEnum.getNodeType() == 1000).findFirst();

        optionalOrderNodeMsgEnum.ifPresent(orderNodeMsgEnum -> System.out.println("orderNodeMsgisNull: " + optionalOrderNodeMsgEnum));

        Optional<OrderNodeMsgEnum> optionalOrderNodeMsgEnum2 = Arrays.stream(OrderNodeMsgEnum.values()).filter(orderNodeMsgEnum -> orderNodeMsgEnum.getNodeType() == 120).findFirst();

        optionalOrderNodeMsgEnum2.ifPresent(orderNodeMsgEnum -> System.out.println("orderNodeMsgisNull_ok: " + optionalOrderNodeMsgEnum2));
    }
}
