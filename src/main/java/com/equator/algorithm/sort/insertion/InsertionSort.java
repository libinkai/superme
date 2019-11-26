package com.equator.algorithm.sort.insertion;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;
import com.equator.algorithm.sort.quick.QuickSort;

/**
 * @Author: Equator
 * @Date: 2019/11/26 23:09
 **/

/**
 * 直接插入排序
 */
public class InsertionSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int len = array.length, i, j, temp;
        for (i = 1; i < len; i++) {
            if (array[i] < array[i - 1]) {
                temp = array[i];
                // j >= 0 && array[j] > temp 不能变换顺序，否则数组越界
                for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateArray(100000, 1000);
        SortUtil.print("排序前", array);
        Sortable insertionSort = new InsertionSort();
        long time = SortUtil.monitor(insertionSort, array);
        SortUtil.print("排序后", array);
        System.out.println("耗时：" + time);
    }
}
