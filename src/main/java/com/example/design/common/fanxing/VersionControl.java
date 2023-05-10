package com.example.design.common.fanxing;

public interface VersionControl {

//     R call() throws ex;
     <T, E extends Throwable> T execute(CallBack<T, E> callBack, Long version) throws E;

    /**
     * 性能监控中执行业务逻辑
     * @return
     */
//    <EX extends Throwable> R call(Long currentVersion, Long newVersion) throws EX;

//
//    <T, E extends Throwable> T execute(RetryCallback<T, E> var1) throws E;
//
//    <T, E extends Throwable> T execute(RetryCallback<T, E> var1, RecoveryCallback<T> var2) throws E;
//
//    <T, E extends Throwable> T execute(RetryCallback<T, E> var1, RetryState var2) throws E, ExhaustedRetryException;
//
//    <T, E extends Throwable> T execute(RetryCallback<T, E> var1, RecoveryCallback<T> var2, RetryState var3) throws E;
}
