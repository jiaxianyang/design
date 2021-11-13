package com.example.design.base;

public class ArrayTest {
    public static void main(String[] args) {
//
//        String str = "";
//        String[] split = str.split(",");
//        for (String s : split) {
//            System.out.println(s);
//            System.out.println("==============");
//        }
        int[] heights = new int[]{2,1,5,6,2,3};
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        for (int newHeight : newHeights) {
            System.out.println(newHeight);
        }

    }
}
