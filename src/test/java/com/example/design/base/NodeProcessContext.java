package com.example.design.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NodeProcessContext {
    /**
     * 仓库标识码
     */
    private String warehouseNo;

    /**
     * 节点类型
     */
    private String nodeType;

    /**
     * 业务编号
     */
    private String businessCode;

    /**
     * 订单类型
     */
    private Integer orderType = 10;

    /**
     * 订单子类型
     */
    private String orderSubType;

    /**
     * businessType
     */
    private String businessType;

    /**
     * 发运单节点类型
     */
    private String shipmentOrderType;

    /**
     * 订单来源
     */
    private String orderSource;

    /**
     * 上下文处理Map
     */
    @Builder.Default
    private Map<String, Object> contextMap = new HashMap<>();

    /**
     * addContextMapData
     * @param key
     * @param object
     */
    public void addContextMapData(String key, Object object) {
        contextMap.put(key, object);
    }

    /**
     * addContextMapData
     *
     * @param key 数据key值
     */
    public Object getContextMapData(String key) {
        return contextMap.get(key);
    }


    /**
     * NodeProcessContextFactory简介
     *
     * @author jiaxianyang
     * @date 2021-06-10 15:15
     */
    @Builder
    public static class NodeProcessContextFactory {

        /**
         * 创建触发回传节点上下文实体
         *
         * @param nodeType 节点类型
         * @param orderType 订单类型
         * @return NodeProcessContext
         */
        public NodeProcessContext createInstanceForTriggerBack(String nodeType, Integer orderType
                , String orderSubType, String orderSource) {
            return NodeProcessContext.builder()
                    .nodeType(nodeType)
                    .orderType(orderType)
                    .orderSubType(orderSubType)
                    .orderSource(orderSource)
                    .build();
        }

        /**
         * 创建触发回传节点上下文实体
         *
         * @param nodeType  节点类型
         * @param orderType 订单类型
         * @return NodeProcessContext
         */
        public NodeProcessContext createInstance(String nodeType, Integer orderType, String orderSource
                , String businessType) {
            return NodeProcessContext.builder()
                    .nodeType(nodeType)
                    .orderType(orderType)
                    .orderSource(orderSource)
                    .businessType(businessType)
                    .build();
        }

    }
}