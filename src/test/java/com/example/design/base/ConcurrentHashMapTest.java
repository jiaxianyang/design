package com.example.design.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiaxianyang
 * @date 2025/2/16 23:12
 */
@ExtendWith(MockitoExtension.class)
public class ConcurrentHashMapTest {
    @Test
    void test1() {
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
