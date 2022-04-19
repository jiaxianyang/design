package com.example.design.spring.aop;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;

@Component
@Aspect
@Slf4j
public class RetryAspectAop {

    @Around(value = "@annotation(com.example.design.spring.aop.MethodPartAndRetryer)")
    public Object around(final ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        final Object[] args = point.getArgs();
        boolean isHandler1 = isHandler(args);
        if (isHandler1) {
            String className = point.getSignature().getDeclaringTypeName();
            String methodName = point.getSignature().getName();
            Object firstArg = args[0];
            List<Object> paramList = (List<Object>) firstArg;
            //获取方法信息
            Method method = getCurrentMethod(point);
            //获取注解信息
            MethodPartAndRetryer retryable = AnnotationUtils.getAnnotation(method, MethodPartAndRetryer.class);
            //重试机制
            Retryer<Object> retryer = new RetryUtil<Object>().getDefaultRetryer(retryable.times(),retryable.waitTime());
            //分片
            List<List<Object>> requestList = Lists.partition(paramList, retryable.parts());
            for (List<Object> partList : requestList) {
                args[0] = partList;
                Object tempResult = retryer.call(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        try {
                            return point.proceed(args);
                        } catch (Throwable throwable) {
                            log.error(String.format("分片重试报错,类%s-方法%s",className,methodName),throwable);
                            throw new RuntimeException("分片重试出错");
                        }
                    }
                });
                if (null != tempResult) {
                    if (tempResult instanceof Boolean) {
                        if (!((Boolean) tempResult)) {
                            log.error(String.format("分片执行报错返回类型不能转化bolean,类%s-方法%s",className,methodName));
                            throw new RuntimeException("分片执行报错!");
                        }
                        result = tempResult;
                    } else if (tempResult instanceof List) {
                        if(result ==null){
                            result = Lists.newArrayList();
                        }
                        ((List) result).addAll((List) tempResult);
                    }else {
                        log.error(String.format("分片执行返回的类型不支持,类%s-方法%s",className,methodName));
                        throw new RuntimeException("不支持该返回类型");
                    }
                } else {
                    log.error(String.format("分片执行返回的结果为空,类%s-方法%s",className,methodName));
                    throw new RuntimeException("调用结果为空");
                }
            }
        } else {
            result = point.proceed(args);
        }
        return result;
    }
    private boolean isHandler(Object[] args) {
        boolean isHandler = false;
        if (null != args && args.length > 0) {
            Object firstArg = args[0];
            //如果第一个参数是list 并且数量大于1
            if (firstArg!=null&&firstArg instanceof List &&((List) firstArg).size()>1) {
                isHandler = true;
            }
        }
        return isHandler;
    }
    private Method getCurrentMethod(ProceedingJoinPoint point) {
        try {
            Signature sig = point.getSignature();
            MethodSignature msig = (MethodSignature) sig;
            Object target = point.getTarget();
            return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

