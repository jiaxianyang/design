package com.example.design.base;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiaxianyang
 * @date 2024/6/7 18:39
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        // 创建一个最小堆优先队列
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 插入元素
        minHeap.add(10);
        minHeap.offer(20);
        minHeap.add(15);

        // 查看优先级最高的元素
        System.out.println("Min element: " + minHeap.peek()); // 输出 10

        // 移除并返回优先级最高的元素
        System.out.println("Extracted min element: " + minHeap.poll()); // 输出 10

        // 查看当前优先级最高的元素
        System.out.println("Min element after extraction: " + minHeap.peek()); // 输出 15

        // 创建一个最大堆优先队列
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // 插入元素
        maxHeap.add(10);
        maxHeap.offer(20);
        maxHeap.add(15);

        // 查看优先级最高的元素
        System.out.println("Max element: " + maxHeap.peek()); // 输出 20

        // 移除并返回优先级最高的元素
        System.out.println("Extracted max element: " + maxHeap.poll()); // 输出 20

        // 查看当前优先级最高的元素
        System.out.println("Max element after extraction: " + maxHeap.peek()); // 输出 15
    }

}
