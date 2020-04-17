package com.equator.leetcode.round1.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/4/15 10:56
 **/

public class ArrayPrinter {
    public static String print(int[][] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(Arrays.toString(array[i]));
            if (i != array.length - 1) {
                sb.append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Test
    public void testPrint() {
        int[][] array = {{1, 2, 3}, {4, 5, 9999}, {7, 8, 9}};
        System.out.println(print(array));
    }
}
