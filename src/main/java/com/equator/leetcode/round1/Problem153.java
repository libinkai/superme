package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/15 17:51
 **/

public class Problem153 {
    public int findMin(int[] nums) {
        int idx1 = 0, idx2 = nums.length - 1, mid = 0;
        while (nums[idx1] > nums[idx2]) {
            if (idx2 - idx1 == 1) {
                mid = idx2;
                break;
            }
            mid = (idx1 + idx2) / 2;
            if (nums[mid] >= nums[idx1]) {
                idx1 = mid;
            } else if (nums[mid] <= nums[idx2]) {
                idx2 = mid;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Problem153().findMin(nums));
    }
}
