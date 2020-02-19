package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/15 18:44
 **/

public class Problem154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int left = 0, right = len - 1, mid = 0;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                // 遇到 nums[mid] == nums[right] 的时候，不能草率地下定结论最小数字在哪一边，但是可以确定的是，把 right 舍弃掉，并不影响结果
                right = right - 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
