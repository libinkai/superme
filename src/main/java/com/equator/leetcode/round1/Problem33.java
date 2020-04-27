package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/4/27 7:37
 **/

public class Problem33 {
    // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段，接下来再判断 target 是在 mid 的左边还是右边，从而来调整左右边界 lo 和 hi
    // 对比 4 5 6 7 0 1 2 以及 6 7 0 1 2 4 5很好懂
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 1));
    }

    // 数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] target=0
//    private int searchNum(int[] nums, int target, int low, int high) {
//        if (low == high) {
//            if (nums[low] == target) {
//                return low;
//            } else {
//                return -1;
//            }
//        }
//        int mid = (low + high) / 2;
//        if (nums[mid] < target) {
//            return searchNum(nums, target, mid + 1, high);
//        } else if (nums[mid] > target) {
//            return
//        } else {
//            return mid;
//        }
//    }
}
