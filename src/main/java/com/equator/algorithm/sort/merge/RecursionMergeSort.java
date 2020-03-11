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
     * 将[left,middle)、[middle,right]两个各自有序的数组合并到同一个数组
     * 即回归到“合并两个有序数组”
     * 不可能做到原地排序，因为空间有限，需要创建额外的数组
     *
     * @param array  原数组
     * @param left   左边子序列下标
     * @param middle 分割下标
     * @param right  右边子序列下标
     */
    public void merge(int[] array, int left, int middle, int right) {
        // 计算俩个区间的大小并创建对应的数组，将原来的数据分别拷贝进去
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
        //合并（回归到合并有序数组）
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
        // 递归出口：只有一个元素
        if (left == right) {
            return;
        }
        // 区间划分[left,middle] (middle,right]
        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        // 合并 [left,middle] (middle,right]
        merge(array, left, middle + 1, right);
    }

    public static void main(String[] args) {
        SortUtil.sort(new RecursionMergeSort());
    }
}
