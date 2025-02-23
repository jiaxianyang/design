package com.example.design.interview;

/**
 * 美团面试题   算法 a 开 b 次方 的值
 */
public class RootCalculation {

    public static void main(String[] args) {
        double a = 8.0; // 被开方数
        int b = 3; // 根次

        double result = nthRoot(a, b);

        System.out.printf("%.6f 的 %d 次方根是: %.6f%n", a, b, result);

        System.out.println(a + " 的 " + b + " 次方根是: " + result);
    }

    public static double nthRoot(double a, int b) {
        if (a < 0 && b % 2 == 0) {
            throw new IllegalArgumentException("负数不能有偶数次方根");
        }

        double low = 0;
        double high = Math.max(1, a);
        double epsilon = 1e-10; // 精度

        while (high - low > epsilon) {
            double mid = (low + high) / 2;
            double midPow = power(mid, b);

            if (midPow < a) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2;
    }

    // 手动计算 x 的 n 次方
    private static double power(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }
}

