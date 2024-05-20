package com.example.design.concurrent.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author jiaxianyang
 * @date 2024/5/19 13:23
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
