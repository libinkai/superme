package com.equator.algorithm.sort.radix;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/27 9:34
 **/

public class RadixSort {
    private int getCharByIdx(String str, int idx) {
        //如果字符串长度小于k，直接返回0，相当于给不存在的位置补0
        if (str.length() < idx + 1) {
            return 0;
        }
        return str.charAt(idx);
    }

    private int getMaxLength(String[] strings) {
        int max = Integer.MIN_VALUE;
        for (String string : strings) {
            max = Math.max(max, string.length());
        }
        return max;
    }

    public String[] sort(String[] array) {
        int maxLength = getMaxLength(array);
        String[] sortedArray = new String[array.length];
        for (int i = maxLength - 1; i >= 0; i--) {
            // ASCII SIZE
            int[] count = new int[128];
            // 计数排序
            // 创建统计数组
            for (int j = 0; j < array.length; j++) {
                // 第i位的字符ASCII码
                int idx = getCharByIdx(array[j], i);
                count[idx]++;
            }
            // 统计数组变形优化
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            // 排序
            for (int j = array.length - 1; j >= 0; j--) {
                int idx = getCharByIdx(array[j], i);
                int sortedIdx = count[idx] - 1;
                sortedArray[sortedIdx] = array[i];
                count[idx]--;
            }
            // 下一轮排序需要以上一轮的排序结果为基础，因此把结果复制给array
            array = sortedArray.clone();
        }
        return array;
    }

    public static void main(String[] args) {
        String[] array = {"abc", "bbb", "ccc", "cf", "gg"};
        new RadixSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
