package com.equator.algorithm.sort.shell;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;
import com.equator.algorithm.sort.insertion.InsertionSort;
import com.equator.algorithm.sort.quick.QuickSortBetter;

/**
 * @Author: Equator
 * @Date: 2019/11/27 9:59
 **/

/**
 *  希尔排序，将数组按照 增量 （步长）划分为子序列，再对子序列进行直接插入排序
 */
public class ShellSort implements Sortable {
    @Override
    public void sort(int[] array) {
        int increment = array.length, len = array.length, i, j, temp;
        do {
            // 计算增量，增量最后必须为1，进行全盘扫描
            increment = increment / 3 + 1;
            for (i = increment; i < len; i++) {
                if (array[i] < array[i - increment]) {
                    temp = array[i];
                    for (j = i - increment; j >= 0 && array[j] > temp; j -= increment) {
                        // 数据后移
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = temp;
                }
            }
        } while (increment > 1);
    }

    public static void main(String[] args) {
        // SortUtil.sort(new ShellSort());
        int[] array = {5, 3, 4, 6, 2};
        SortUtil.print("排序前", array);
        long time = SortUtil.monitor(new ShellSort(), array);
        SortUtil.print("排序后", array);
        System.out.println("耗时：" + time);
    }
}
