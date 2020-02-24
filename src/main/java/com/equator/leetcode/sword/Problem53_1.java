package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/24 9:41
 **/

public class Problem53_1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = getFirstKIdx(nums, target, 0, nums.length - 1);
        int last = getLastKIdx(nums, target, 0, nums.length - 1);
        if (first > -1 && last > -1) {
            return last - first + 1;
        }
        return 0;
    }

    private int getFirstKIdx(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIdx = (start + end) / 2, midVal = nums[midIdx];
        if (midVal == target) {
            if ((midIdx > 0 && nums[midIdx - 1] != target) || midIdx == 0) {
                return midIdx;
            } else {
                end = midIdx - 1;
            }
        } else if (midVal > target) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }
        return getFirstKIdx(nums, target, start, end);
    }

    private int getLastKIdx(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIdx = (start + end) / 2, midVal = nums[midIdx];
        if (midVal == target) {
            if ((midIdx < nums.length - 1 && nums[midIdx + 1] != target) || midIdx == nums.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midVal > target) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }
        return getLastKIdx(nums, target, start, end);
    }
}
