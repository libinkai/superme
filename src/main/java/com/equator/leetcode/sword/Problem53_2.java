package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/24 9:56
 **/

public class Problem53_2 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (left == nums.length) {
            return nums.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Problem53_2().missingNumber(nums));
    }
}
