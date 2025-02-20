package com.example.design.utils.vo;

import lombok.Data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 设计VO
 *
 * @author jiaxianyang
 * @date 2024/7/31 14:15
 */
@Data
public class DesignVo<S> implements Iterable<S> {

    private static final String PREFIX = "META-INF/services/";

    private LinkedHashMap<String, S> providers = new LinkedHashMap<>();

    private LazyIterator lazyIterator;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public DesignVo(Class<S> service, ClassLoader loader) {
        providers.clear();
        lazyIterator = new DesignVo.LazyIterator(service, loader);
    }

    public static <S> DesignVo<S> load(Class<S> service) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return DesignVo.load(service, cl);
    }

    public static <S> DesignVo<S> load(Class<S> service,
                                       ClassLoader loader) {
        return new DesignVo<>(service, loader);
    }

    @Override
    public Iterator<S> iterator() {
        return new Iterator<S>() {

            Iterator<Map.Entry<String, S>> knownProviders
                    = providers.entrySet().iterator();

            public boolean hasNext() {
                if (knownProviders.hasNext())
                    return true;
                return lazyIterator.hasNext();
            }

            public S next() {
                if (knownProviders.hasNext())
                    return knownProviders.next().getValue();
                return lazyIterator.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    private class LazyIterator
            implements Iterator<S> {

        Class<S> service;
        ClassLoader loader;

        private LazyIterator(Class<S> service, ClassLoader loader) {
            this.service = service;
            this.loader = loader;
        }

        public boolean hasNext() {
            return true;
        }

        public S next() {
            S s = (S) new Object();
            int key = atomicInteger.incrementAndGet();
            providers.put(String.valueOf(key), s);
            return s;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


}
