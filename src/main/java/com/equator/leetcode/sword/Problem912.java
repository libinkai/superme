package com.equator.leetcode.sword;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/31 8:13
 **/

public class Problem912 {
    // 错误了，没考虑负数 [3,-1]，只考虑了最大值
    public int[] sortArray0(int[] nums) {
        int[] res = new int[nums.length];
        int[] flag = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < flag.length; i++) {
            while (flag[i] > 0) {
                res[idx] = i;
                idx++;
                flag[i]--;
            }
        }
        return res;
    }

    public int[] sortArray1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int key = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= key) {
                high--;
            }
            swap(nums, low, high);
            while (low < high && nums[low] <= key) {
                low++;
            }
            swap(nums, low, high);
        }
        return low;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 计数排序
    public int[] sortArray2(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int len = max - min;
        // 统计数组长度是len+1哦
        int[] flag = new int[len + 1];
        // 以min作为偏移量
        for (int num : nums) {
            flag[num - min]++;
        }
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < flag.length; i++) {
            while (flag[i] > 0) {
                res[idx] = i + min;
                idx++;
                flag[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -5, -2, 1, 4, 3};
        System.out.println(Arrays.toString(new Problem912().sortArray2(nums)));
    }
}
