package com.example.design.interview;

/**
 * 美团面试题   算法 a 开 b 次方 的值
 */
public class RootCalculation2 {
    public static void main(String[] args) {
        double a = 8;
        double b = 3;
        double result = nthRoot(a, b);
        System.out.println("The " + b + "th root of " + a + " is: " + result);
    }

    public static double nthRoot(double a, double b) {
        if (a == 0) return 0; // 0 的任何次方根都是 0
        if (b == 0) return Double.NaN; // 0 次方根无意义

        double epsilon = 1e-7; // 精度
        double low = 0;
        double high = a;
        double mid;

        // 如果 a < 1，调整搜索区间
        if (a < 1) {
            high = 1;
        }

        while (high - low > epsilon) {
            mid = (low + high) / 2;
            double midValue = power(mid, b);

            if (midValue < a) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2;
    }

    // 自定义幂运算函数
    public static double power(double base, double exponent) {
        if (exponent == 0) return 1;
        if (exponent < 0) return 1 / power(base, -exponent);

        double result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent = (int) exponent / 2;
        }
        return result;
    }
}

