package com.example.design.concurrent.disruptor;

import com.example.design.utils.json.JsonUtil;
import com.lmax.disruptor.EventHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxianyang
 * @date 2024/5/19 13:36
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(event.getValue());
    }

    public LongEventHandler() {
    }
}
