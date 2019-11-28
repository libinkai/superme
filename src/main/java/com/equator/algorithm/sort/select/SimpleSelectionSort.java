package com.equator.algorithm.sort.select;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/11/27 22:35
 **/

/**
 * 直接选择排序
 */
public class SimpleSelectionSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int len = array.length, min;
        for (int i = 1; i < len - 1; i++) {
            // 设i即为最小元素下标
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // i 不等于 min 说明剩余元素找到一个最小值，否则i即为最小元素
            if (i != min) {
                SortUtil.swap(array, i, min);
            }
        }
    }

    public static void main(String[] args) {
        SortUtil.sort(new SimpleSelectionSort());
    }
}
