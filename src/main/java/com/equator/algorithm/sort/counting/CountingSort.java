package com.equator.algorithm.sort.counting;

import com.equator.algorithm.sort.SortUtil;
import com.equator.algorithm.sort.Sortable;

/**
 * @Author: Equator
 * @Date: 2019/12/2 10:41
 **/

public class CountingSort {
    public static int[] sort(int[] array) {
        int max = array[0], min = array[0], len = array.length;
        // 找到待排序数组的最大值与最小值
        for (int i = 0; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 计算跨度，创建统计数组
        int span = max - min;
        int[] countArray = new int[span + 1];
        // 统计
        for (int i = 0; i < len; i++) {
            countArray[array[i] - min]++;
        }
        // 优化，改变统计数组使得后面的元素等于前面的元素之和
        int sum = 0;
        for (int i = 0, countArrayLen = countArray.length; i < countArrayLen; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        // 倒序遍历原始数列，从统计数组找到正确位置，得到结果数组
        int[] resultArray = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            // countArray[array[i] - min] 统计数组中该值的预期位置
            resultArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.generateArray(100000, 10000);
        SortUtil.print("排序前", array);
        long start = System.currentTimeMillis();
        array = sort(array);
        long end = System.currentTimeMillis();
        SortUtil.print("排序后", array);
        System.out.println("耗时：" + (end - start));
    }
}
