package com.example.design.base;

import com.example.design.common.enums.ShipmentOrderMainFieldEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringTest {

    /**
     * 格式化字串形式
     */
    private static final String FORMAT = "%s_%s";

    public static void main(String[] args) {
        List<ShipmentOrderMainFieldEnum> shipmentOrderMainFieldEnums = Lists.newArrayList(ShipmentOrderMainFieldEnum.ID, ShipmentOrderMainFieldEnum.CARRIER_NAME, ShipmentOrderMainFieldEnum.SHIPMENT_ORDER_NO);
        System.out.println(buildMainColumnsSql(shipmentOrderMainFieldEnums));


        System.out.println(String.format(FORMAT, "70", "10@1", 00));

        System.out.println(StringUtils.joinWith("_", "70", "10@1", null));

        List<String> groupKeys = Lists.newArrayList("A", "B", "C", "D", "E");
        String groupKey = buildGroupKey(groupKeys);
        System.out.println(groupKey);
    }


    private static String buildGroupKey(List<String> groupKeys) {
        String groupKey = "";
        if (groupKeys.contains("A")) {
            groupKey = StringUtils.join(groupKey, "A");
        }
        if (groupKeys.contains("B")) {
            groupKey = StringUtils.join(groupKey, "B");
        }
        if (groupKeys.contains("C")) {
            groupKey = StringUtils.join(groupKey, "C");
        }
        if (groupKeys.contains("D")) {
            groupKey = StringUtils.join(groupKey, "D");
        }
        if (groupKeys.contains("E")) {
            groupKey = StringUtils.join(groupKey, "E");
        }
        return groupKey;
    }

    private static String buildMainColumnsSql(List<ShipmentOrderMainFieldEnum> shipmentOrderMainFieldEnums) {
        if (CollectionUtils.isNotEmpty(shipmentOrderMainFieldEnums)) {
            shipmentOrderMainFieldEnums.add(ShipmentOrderMainFieldEnum.ID);
            shipmentOrderMainFieldEnums.add(ShipmentOrderMainFieldEnum.SHIPMENT_ORDER_NO);

            return StringUtils.join(shipmentOrderMainFieldEnums.stream()
                            .map(ShipmentOrderMainFieldEnum::getFieldName).collect(Collectors.toList())
                    , ",");
        }
        return null;
    }
}
