package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/2 23:13
 **/

public class Problem27 {
    public int removeElement0(int[] nums, int val) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

    public int removeElement1(int[] nums, int val) {
        int len = nums.length, i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }
}
