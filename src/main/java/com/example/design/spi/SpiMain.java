package com.example.design.spi;

import org.springframework.core.OrderComparator;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * spi main
 *
 * @author jiaxianyang
 * @date 2024/7/31 11:21
 */
public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        IShout iShout = StreamSupport.stream(shouts.spliterator(), false).min(OrderComparator.INSTANCE).get();
        for (IShout s : shouts) {
            s.shout();
        }
        System.out.println("===================== end");
    }
}
