package com.example.design.spring.aop;

import java.util.concurrent.TimeUnit;

public class RetryUtil<V> {
    public Retryer<V> getDefaultRetryer(int times,long waitTime) {
        Retryer<V> retryer = RetryerBuilder.<V>newBuilder()
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .withWaitStrategy(WaitStrategies.fixedWait(waitTime, TimeUnit.MILLISECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(times))
                .build();
        return retryer;
    }
}
