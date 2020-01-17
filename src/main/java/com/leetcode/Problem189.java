package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/17 7:52
 **/

public class Problem189 {
    // 类似于汇编的循环右移
    public void rotate1(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    // 三次反转
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int a, int b) {
        int temp;
        while (a < b) {
            temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }

    // 环状替换
    public void rotate3(int[] nums, int k) {

    }
}
