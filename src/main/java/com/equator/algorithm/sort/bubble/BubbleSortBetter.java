package com.equator.algorithm.sort.bubble;

/**
 * @Author: Equator
 * @Date: 2019/11/26 20:01
 **/

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * 冒泡排序提升版，如果一趟排序完毕没有发现需要交换的，则说明排序已经完成
 */
public class BubbleSortBetter implements Sortable {
    @Override
    public void sort(int[] array) {
        int len = array.length;
        boolean flag = true;
        for (int i = 0; i < len && flag; i++) {
            flag = false;
            for (int j = len - 1; j >= i; j--) {
                if (array[i] > array[j]) {
                    SortUtil.swap(array, i, j);
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortUtil.sort(new BubbleSortBetter());
    }
}
