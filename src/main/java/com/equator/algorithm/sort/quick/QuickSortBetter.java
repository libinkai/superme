package com.equator.algorithm.sort.quick;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/11/26 20:36
 **/

public class QuickSortBetter implements Sortable {
    @Override
    public void sort(int[] array) {
        int low = 0, high = array.length - 1;
        sort(array, low, high);
    }

    public void sort(int[] array, int low, int high) {
        int pivot;
        while (low < high) {
            pivot = partition(array, low, high);
            sort(array, low, pivot - 1);
            // 尾递归
            low = pivot + 1;
        }
    }

    public int partition(int[] array, int low, int high) {
        // 取数组第一个数作为比较的键值
        int key = array[low];
        while (low < high) {
            // 找到一个比键值小的数据，并交换到低端
            while (low < high && array[high] >= key) {
                high--;
            }
            SortUtil.swap(array, low, high);
            // 找到一个比键值大的数据下标，并交换到高端
            while (low < high && array[low] <= key) {
                low++;
            }
            SortUtil.swap(array, low, high);
        }
        // 最终 low 等于 high
        return low;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateArray(100000, 1000);
        SortUtil.print("排序前", array);
        Sortable quickSort = new QuickSortBetter();
        long time = SortUtil.monitor(quickSort, array);
        SortUtil.print("排序后", array);
        System.out.println("耗时：" + time);
    }
}
