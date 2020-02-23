package com.equator.leetcode.sword;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/23 7:59
 **/

public class Problem51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        return rec(nums, copy, 0, nums.length - 1);
    }

    private int rec(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }
        int len = (end - start) / 2;
        // 交换了数组
        int left = rec(copy, nums, start, start + len);
        int right = rec(copy, nums, start + len + 1, end);
        int i = start + len, j = end, k = end;
        int count = 0;
        while (i >= start && j >= start + len + 1) {
            if (nums[i] > nums[j]) {
                copy[k--] = nums[i--];
                count += j - start - len;
            } else {
                copy[k--] = nums[j--];
            }
        }
        while (i >= start) {
            copy[k--] = nums[i--];
        }
        while (j >= start + len + 1) {
            copy[k--] = nums[j--];
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new Problem51().reversePairs(nums));
    }
}
