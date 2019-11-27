package com.equator.algorithm.sort.shell;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;
import com.equator.algorithm.sort.insertion.InsertionSort;
import com.equator.algorithm.sort.quick.QuickSortBetter;

/**
 * @Author: Equator
 * @Date: 2019/11/27 9:59
 **/

public class ShellSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int increment = array.length, len = array.length, i, j, temp;
        do {
            increment = increment / 3 + 1;
            for (i = increment + 1; i < len; i++) {
                if (array[i] < array[i - increment]) {
                    temp = array[i];
                    for (j = i - increment; j >= 0 && array[j] > temp; j -= increment) {
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = temp;
                }
            }
        } while (increment > 1);
    }

    public static void main(String[] args) {
        SortUtil.sort(new ShellSort());
    }
}
