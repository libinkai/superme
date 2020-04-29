package com.equator.algorithm.searching;

import org.junit.Test;

/**
 * 对于区间的开闭的定义：[0，len-1]为闭区间，(-1,len)开区间，[0,len)左闭右开，(-1,len-1]左开右闭，对于闭的一侧，mid是可以跳过的
 *
 * @Author: Equator
 * @Date: 2020/4/29 11:57
 **/

public class BinarySearchDemo {
    private int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * 1 2 3  4 5 6  7 8 9 10
     * -1 1 2 -1 4 5 -1 7 8 -1
     * 错误的写法
     */
    private int binarySearch1(int[] nums, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 正确的做法
     */
    private int binarySearch2(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 死循环
     */
    private int binarySearch3(int[] nums, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid;
            } else if (target < nums[mid]) {
                high = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 闭区间
     */
    @Test
    public void test1() {
        int low = 0, high = nums.length - 1;
        for (int num : nums) {
            System.out.println(binarySearch1(nums, num, 0, nums.length - 1));
        }
        System.out.println("------");
        for (int num : nums) {
            System.out.println(binarySearch2(nums, num, 0, nums.length - 1));
        }
        System.out.println("------");
        for (int num : nums) {
            System.out.println(binarySearch3(nums, num, 0, nums.length - 1));
        }
    }
}
