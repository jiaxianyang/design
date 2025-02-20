package com.example.design.utils;

/**
 * @author jiaxianyang
 * @date 2024/11/29 16:47
 */
import java.util.Arrays;
import java.util.Random;

public class LargeDataSearch {
    private static final int SIZE = 1_000_000_000;
    private static int[] sortedData;

    public static void main(String[] args) {
        // 初始化并排序数据
        initializeData();

        // 示例查询
        Random random = new Random();
        int target = sortedData[random.nextInt(SIZE)];

        // 查询目标元素
        long startTime = System.nanoTime();
        int index = binarySearchDescending(sortedData, target);
        long endTime = System.nanoTime();

        if (index >= 0) {
            System.out.println("元素 " + target + " 在索引 " + index + " 处找到。");
        } else {
            System.out.println("元素 " + target + " 未找到。");
        }
        System.out.println("查询耗时: " + (endTime - startTime) + " 纳秒");
    }

    // 初始化并排序数据
    private static void initializeData() {
        sortedData = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            sortedData[i] = random.nextInt();
        }

        // 对数据进行从小到大排序
        Arrays.sort(sortedData);

        // 反转数组，使其从大到小排序
        for (int i = 0; i < SIZE / 2; i++) {
            int temp = sortedData[i];
            sortedData[i] = sortedData[SIZE - 1 - i];
            sortedData[SIZE - 1 - i] = temp;
        }
    }

    // 从大到小排序的二分查找实现
    public static int binarySearchDescending(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = data[mid];

            if (midVal > target) {
                low = mid + 1;
            } else if (midVal < target) {
                high = mid - 1;
            } else {
                return mid; // 找到目标元素
            }
        }
        return -1; // 未找到目标元素
    }
}
