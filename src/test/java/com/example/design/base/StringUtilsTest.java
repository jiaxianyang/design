package com.example.design.base;

import com.example.design.utils.json.JsonUtil;
import com.example.design.utils.json.TypeReference;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class StringUtilsTest {
    public static void main(String[] args) {
        System.out.println(StringUtils.isNotEmpty(""));
        String uuid = getAttributeValInBody("uuid", "{\"needWaitPalletComplete\":false,\"items\":[{\"sku\":\"100010118577\",\"sortedQty\":5.0000,\"warehouseNo\":\"6_979\",\"shipmentOrderNo\":\"SO-6_979-1533655847530409984\",\"orderNo\":\"wms6-uat1654486995094\",\"operator\":\"xuguigui\",\"operateTime\":\"2022-06-06 11:46:16\",\"uuid\":\"1533656440638558208\",\"flowType\":1,\"orderLineNo\":1533655847614296064,\"tenantCode\":\"TC86262552\",\"trayContainerFlag\":false}]}");

        System.out.println(uuid);
    }

    static String getAttributeValInBody(String attributeKey,String messageText) {
        if (StringUtils.isEmpty(messageText)) {
            return null;
        }

        Map<String, Object> messageMap = JsonUtil.parseObject(messageText, new TypeReference<Map<String, Object>>() {;
        });
        return MapUtils.getString(messageMap, attributeKey);
    }
}
