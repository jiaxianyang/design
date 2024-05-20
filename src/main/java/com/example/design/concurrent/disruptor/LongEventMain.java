package com.example.design.concurrent.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiaxianyang
 * @date 2024/5/19 14:28
 */
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {

//
//         用lambda表达式来注册EventHandler和EventProductor

        // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();
        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;
        // Construct the Disruptor

        Disruptor<LongEvent> disruptor = new Disruptor(new LongEventFactory(),
                bufferSize, executor,
                ProducerType.MULTI, new BusySpinWaitStrategy()
               );

//        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, executor);
        // Connect the handler
        disruptor.handleEventsWith(LongEventWithMethodRef::handleEvent);
        // Start the Disruptor, starts all threads running
        disruptor.start();
        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++)
        {
            bb.putLong(0, l);
            ringBuffer.publishEvent(LongEventWithMethodRef::translate, bb);
            Thread.sleep(1000);
        }

//            // Executor that will be used to construct new threads for consumers
//        Executor executor = Executors.newCachedThreadPool();
//        // The factory for the event
//        LongEventFactory factory = new LongEventFactory();
//        // Specify the size of the ring buffer, must be power of 2.
//        int bufferSize = 1024;
//        // Construct the Disruptor
//        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, executor);
//        // Connect the handler
//        disruptor.handleEventsWith(new LongEventHandler());
//        // Start the Disruptor, starts all threads running
//        disruptor.start();
//        // Get the ring buffer from the Disruptor to be used for publishing.
//        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
//
//        LongEventProducer producer = new LongEventProducer(ringBuffer);
//
//        ByteBuffer bb = ByteBuffer.allocate(8);
//        for (long l = 0; true; l++) {
//            bb.putLong(0, l);
//            producer.onData(bb);
//        }
    }
}
