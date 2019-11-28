package com.equator.algorithm.sort.merge;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/11/28 12:08
 **/

public class RecursionMergeSort implements Sortable {
    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 合并
     *
     * @param array  原数组
     * @param left   左边子序列下标
     * @param middle 分割下标
     * @param right  右边子序列下标
     */
    public void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left;
        int rightSize = right - middle + 1;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = left; i < middle; i++) {
            leftArray[i - left] = array[i];
        }
        for (int i = middle; i <= right; i++) {
            rightArray[i - middle] = array[i];
        }
        //合并
        int i = left, j = 0, k = 0;
        while (j < leftSize && k < rightSize) {
            if (leftArray[j] < rightArray[k]) {
                array[i++] = leftArray[j++];
            } else {
                array[i++] = rightArray[k++];
            }
        }
        while (j < leftSize) {
            array[i++] = leftArray[j++];
        }
        while (k < rightSize) {
            array[i++] = rightArray[k++];
        }
    }

    public void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        merge(array, left, middle + 1, right);
    }

    public static void main(String[] args) {
        SortUtil.sort(new RecursionMergeSort());
    }
}
