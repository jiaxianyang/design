package com.example.design.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author jiaxianyang
 * @date 2025/1/24 21:57
 */
@ExtendWith(MockitoExtension.class)
public class IntegerTest {
    public static void main(String[] args) {
        Integer integer1 = 3;
        Integer integer2 = 3;
        if (integer1 == integer2) {
            System.out.println("integer1 == integer2");
        } else {
            System.out.println("integer1 != integer2");
        }

        Integer integer3 = 300;
        Integer integer4 = 300;
        if (integer3 == integer4) {
            System.out.println("integer3 == integer4");
        } else {
            System.out.println("integer3 != integer4");
        }

        System.out.println((0.1 + 0.2) != 0.3);
        System.out.println(Math.abs(-2147483648));
    }

    @Test
    @DisplayName("java是值传递，只不过对象是共享对象传递，复制的是引用地址")
    void test2() {
       int a = 10;
       changeIntValue(a);
        System.out.println(a);
    }

    private void changeIntValue(int a) {
        a++;
    }
}
