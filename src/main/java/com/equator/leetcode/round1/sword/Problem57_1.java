package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/25 9:55
 **/

public class Problem57_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }
}
