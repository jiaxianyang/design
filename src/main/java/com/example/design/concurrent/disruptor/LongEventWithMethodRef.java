package com.example.design.concurrent.disruptor;

import java.nio.ByteBuffer;

/**
 * @author jiaxianyang
 * @date 2024/5/19 16:04
 */
public class LongEventWithMethodRef {
    public static void handleEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println(event.getValue());
    }

    public static void translate(LongEvent event, long sequence, ByteBuffer buffer)
    {
        event.setValue(buffer.getLong(0));
    }
}
