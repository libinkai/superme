package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/27 14:19
 **/

public class Problem303 {
    static class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        System.out.println(new NumArray(nums).sumRange(0, 5));
        ;
    }
}
