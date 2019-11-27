package com.equator.algorithm.sort.bubble;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/11/26 19:13
 **/

/**
 * 冒泡排序，从前往后两两比较，如果满足交换条件则交换
 */
public class BubbleSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                if (array[i] > array[j]) {
                    SortUtil.swap(array, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        SortUtil.sort(new BubbleSort());
    }
}
