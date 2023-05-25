package com.example.design.base;

import com.example.design.utils.json.JsonUtil;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) throws InterruptedException {
//
//
//        List<List<String>> partition = Lists.newArrayList();
//        for (List<String> strings : partition) {
//            System.out.println(strings);
//        }
//        System.out.println(partition.get(0));


        int[] nums = {2, 9, 1, 10, 0, 11, 9, 13};
        Arrays.sort(nums);
        System.out.println(JsonUtil.toJsonString(nums));
        System.out.println(0 / 2 + 1);




//        public static void main(String[] args) {
//            DeviceNotification<OutboundBillStatusFeedbackRequest> deviceNotification = new DeviceNotification<>();
//            Header header = new Header();
//            header.setWarehouseNo("6_6_618");
//            deviceNotification.setHeader(header);
//            OutboundBillStatusFeedbackRequest outboundBillStatusFeedbackRequest = new OutboundBillStatusFeedbackRequest();
//            outboundBillStatusFeedbackRequest.setUuid("SO-6_6_618-1621010426361806848_jia");
//            List<OutboundBillStatus> outboundList = new ArrayList<>();
//            OutboundBillStatus outboundBillStatus = new OutboundBillStatus();
//            outboundBillStatus.setOutboundNo("100016867");
//            outboundBillStatus.setOutboundStatus(20);
//            outboundBillStatus.setWaveNo("SO-6_6_618-1621010426361806848_16210105042835947520");
//            outboundBillStatus.setUpdateTime("2023-05-25 16:14:37");
//            outboundBillStatus.setUpdateUser("jiaxianyang");
//
//            outboundList.add(outboundBillStatus);
//            outboundBillStatusFeedbackRequest.setOutboundList(outboundList);
//            deviceNotification.setPayload(outboundBillStatusFeedbackRequest);
//
//            System.out.println(JsonUtil.toJsonString(deviceNotification));
//        }

    }
}
