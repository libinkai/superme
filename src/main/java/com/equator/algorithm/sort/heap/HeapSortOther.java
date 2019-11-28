package com.equator.algorithm.sort.heap;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/11/27 22:54
 **/

/**
 * 堆排序 对完全二叉树进行0为开始下标的层序遍历
 * 对于一个节点，其下标为i，则
 * 其父节点为 (i-1)/2
 * 左孩子为 2i+1
 * 右孩子为 2i+2
 */
public class HeapSortOther implements Sortable {
    @Override
    public void sort(int[] array) {
        int len = array.length;
        int lastNodeIndex = len - 1;
        // 从最后一个有孩子的节点（即最后一个叶子节点的父节点）开始建立大顶堆
        for (int i = (lastNodeIndex - 1) / 2; i >= 0; i--) {
            heapify(array, len, i);
        }
        // 从最后一个节点 i 开始，依次和堆顶 0 进行交换
        for (int i = lastNodeIndex; i >= 0; i--) {
            SortUtil.swap(array, i, 0);
            // 堆（待排序的序列）不断缩短，故将i作为len传入函数
            heapify(array, i, 0);
        }
    }

    /**
     * 非递归的方式调整大顶堆
     *
     * @param array
     * @param len
     * @param index
     */
    public void heapify(int[] array, int len, int index) {
        int temp = array[index];
        // 2*index+1 表示其为左孩子
        for (int i = 2 * index + 1; i < len; i = 2 * i + 1) {
            // 左孩子小于右孩子，则 i 指向右孩子
            if (i < len - 1 && array[i] < array[i + 1]) {
                i++;
            }
            // 父节点大于左孩子与右孩子（此时i指向最大的节点），则无需调整
            if (temp >= array[i]) {
                break;
            }
            // 将最大的节点调整到index处
            array[index] = array[i];
            index = i;
        }
        array[index] = temp;
    }

    public static void main(String[] args) {
        SortUtil.sort(new HeapSortOther());
    }
}
