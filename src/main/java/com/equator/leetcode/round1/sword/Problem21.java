package com.equator.leetcode.round1.sword;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/18 9:09
 **/

public class Problem21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 第一个偶数
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            // 倒数第一个奇数
            while (left < right && nums[right] % 2 != 1) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(Arrays.toString(new Problem21().exchange(nums)));
    }
}
