package com.equator.leetcode.round2.sword;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/4/24 16:51
 **/

public class Solution51 {
    // 暴力（超时）
    public int reversePairs0(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    num++;
                }
            }
        }
        return num;
    }

    public int reversePairs1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return count(nums, 0, nums.length - 1);
    }

    private int count(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = count(nums, start, mid) + count(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += nums[i] <= nums[j] ? j - (mid + 1) : 0;
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, end - start + 1);
        return count;
    }


    @Test
    public void test() {
//        int[] nums = {7, 5, 6, 4};
        int[] nums = {3, 2, 5, 6};
        System.out.println(new Solution51().reversePairs1(nums));
    }
}
