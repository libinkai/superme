package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/24 12:31
 **/

public class Problem56_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int idx = getFirstBitIdx(xor);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (isBit(nums[i], idx)) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

    private boolean isBit(int num, int idx) {
        num >>= idx;
        return (num & 1) == 1 ? true : false;
    }

    private int getFirstBitIdx(int num) {
        int idx = 0;
        while (((num & 1) == 0) && idx < 32) {
            num >>= 1;
            idx++;
        }
        return idx;
    }
}
