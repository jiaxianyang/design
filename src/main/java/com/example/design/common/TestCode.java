package com.example.design.common;

import com.example.design.utils.json.JsonUtil;

/**
 * @author jiaxianyang
 * @date 2024/4/2 20:07
 */
public class TestCode {

    public static void main(String[] args) {
        int[] mergedArray = mergeArray(new int[]{1, 3}, new int[]{2, 4, 8, 10});
        System.out.println(JsonUtil.toJsonString(mergedArray));
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] result = new int[length1 + length2];
        int start1 = 0;
        int start2 = 0;
        int resultPos = 0;
        while (start1 < length1 || start2 < length2) {
            if (start1 == length1) {
                result[resultPos++] = array2[start2++];
            } else if (start2 == length2) {
                result[resultPos++] = array1[start1++];
            } else if (array1[start1] < array2[start2]) {
                result[resultPos++] = array1[start1++];
            } else {
                result[resultPos++] = array2[start2++];
            }
        }
        return result;
    }
}
