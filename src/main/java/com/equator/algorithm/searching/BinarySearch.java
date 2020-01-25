package com.equator.algorithm.searching;

/**
 * @Author: Equator
 * @Date: 2020/1/25 7:08
 **/

// 二分查找的前提：目标函数的单调性、上下界、可以随机访问（索引访问）
public class BinarySearch {
    // 二分查找返回目标的下标 注意，以下代码适用于升序排列的数组
    public int binarySearch1(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public void test() {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("target=%d idx=%d res=%d\n", nums[i], i, binarySearch2(nums, nums[i]));
        }
    }

    public static void main(String[] args) {
        new BinarySearch().test();
    }
}
