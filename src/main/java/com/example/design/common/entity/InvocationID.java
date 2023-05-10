package com.example.design.common.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvocationID {
    private Long id;
    private String shardingKey;

    public static void main(String[] args) {
        InvocationID invocationID1 = new InvocationID(1L, "1");
        InvocationID invocationID2 = new InvocationID(2L, "1");
        InvocationID invocationID3 = new InvocationID(3L, "1");
        InvocationID invocationID4 = new InvocationID(4L, "1");
        InvocationID invocationID5 = new InvocationID(5L, "1");
        InvocationID invocationID6 = new InvocationID(6L, "1");
        InvocationID invocationID7 = new InvocationID(7L, "1");
        List<InvocationID> invocationIDList = Lists.newArrayList(invocationID1, invocationID2, invocationID3, invocationID4, invocationID5, invocationID6, invocationID7);
        Collections.shuffle(invocationIDList);
        System.out.println(invocationIDList);
        System.out.println(invocationIDList.size());
    }
}
