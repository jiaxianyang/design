package com.example.design.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

/**
 * @author jiaxianyang
 * @date 2024/4/3 15:00
 */
@ExtendWith(MockitoExtension.class)
public class BigDecimalTest {

    @Test
    void testConvert() {
        BigDecimal bigDecimal = new BigDecimal("7.1");
        System.out.println(bigDecimal.doubleValue());
    }
}
