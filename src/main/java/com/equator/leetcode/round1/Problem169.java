package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/22 10:00
 **/

public class Problem169 {
    public int majorityElement(int[] nums) {
        return dr(nums, 0, nums.length - 1);
    }

    public int dr(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int center = (low + high) / 2;
        int left = dr(nums, low, center);
        int right = dr(nums, center + 1, high);
        if (left == right) {
            return left;
        }
        int leftCount = count(nums, left, low, high);
        int rightCount = count(nums, right, low, high);
        return leftCount > rightCount ? left : right;
    }

    public int count(int[] nums, int target, int low, int high) {
        int count = 0;
        for (int i = low; i < high; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}
