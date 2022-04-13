package com.example.design.base;

import com.example.design.utils.json.JsonUtil;

import java.util.List;
import java.util.Map;

public class JsonConvertTest {

    public static void main(String[] args) {
        String str = "{\"ibTransferDeliveryBill\":{\"deliveryBillNo\":\"D291X15122033000000099\",\"source\":\"1\",\"orgNo\":\"-1\",\"distributeNo\":\"635\",\"warehouseNo\":\"12\",\"fromOrgNo\":\"-1\",\"fromDistributeNo\":\"291\",\"fromWarehouseNo\":\"151\",\"deliveryTime\":\"2022-03-30 10:11:03\",\"caseQty\":1,\"carrierCode\":\"\",\"carrierName\":\"\"},\"caseInfos\":[{\"boxTotalQty\":\"0\",\"orgNo\":\"-1\",\"distributeNo\":\"635\",\"warehouseNo\":\"12\",\"inboundStatus\":\"0\",\"totalQty\":2,\"totalWeight\":\"0\",\"totalVolume\":\"0\",\"labelQty\":\"0\",\"purchaseTransFlag\":0,\"carrierNo\":\"\",\"carrierName\":\"\",\"caseType\":\"masterBox\",\"transType\":\"G1\",\"expectedWeight\":\"19735.0000\",\"caseVolume\":\"50220528.0000\",\"caseNo\":\"C291X15122033000000080\",\"caseRealQty\":\"1\",\"ibReceivingTaskDs\":[{\"inboundNo\":\"C291X15122033000000080\",\"productLevel\":\"1\",\"isBox\":0,\"ownerNo\":\"2\",\"orgNo\":\"-1\",\"distributeNo\":\"635\",\"warehouseNo\":\"12\",\"goodsNo\":\"8048364\",\"packingQty\":0,\"packingUnit\":\"件\",\"expectedQty\":1,\"receivedQty\":\"0\",\"returnLossQty\":\"0\",\"lotNo\":\"acef8a75063a88e4e80c41f4de96fca9\",\"boxQty\":\"0\",\"expno\":\"35741538\"},{\"inboundNo\":\"C291X15122033000000080\",\"productLevel\":\"1\",\"isBox\":0,\"ownerNo\":\"2\",\"orgNo\":\"-1\",\"distributeNo\":\"635\",\"warehouseNo\":\"12\",\"goodsNo\":\"100004897943\",\"packingQty\":0,\"packingUnit\":\"件\",\"expectedQty\":1,\"receivedQty\":\"0\",\"returnLossQty\":\"0\",\"lotNo\":\"0a297c71c7ce2727c8e193034f672d47\",\"boxQty\":\"0\",\"expno\":\"35741538\"}]}],\"transGoodsFromWms3s\":[{\"goodsNo\":\"8048364\",\"lotNo\":\"acef8a75063a88e4e80c41f4de96fca9\"},{\"goodsNo\":\"100004897943\",\"lotNo\":\"0a297c71c7ce2727c8e193034f672d47\"}]}";

        Map<String, Object> backDataMap = JsonUtil.parseObject(str, Map.class);

        List<Map<String, Object>> caseInfos = (List<Map<String, Object>>) backDataMap.get("caseInfos");

        for (Map<String, Object> caseInfo : caseInfos) {
            List<Map<String, Object>> ibReceivingTaskDs = (List<Map<String, Object>>) caseInfo.get("ibReceivingTaskDs");
            for (Map<String, Object> ibReceivingTaskD : ibReceivingTaskDs) {
                ibReceivingTaskD.put("innerId", 1);
            }
        }
        System.out.println(JsonUtil.toJsonString(backDataMap));
    }
}
