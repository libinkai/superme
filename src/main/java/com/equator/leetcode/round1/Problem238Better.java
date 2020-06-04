package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/6/4 8:49
 **/

public class Problem238Better {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        // 注意是 i-1 与 i+1
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int temp = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}
