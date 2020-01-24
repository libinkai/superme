package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/24 9:19
 **/

public class Problem45 {
    // 错误的做法，题目假设：总是可以到达数组的最后一个位置，然而不排除某个元素为0的情况
    public int jump0(int[] nums) {
        int ans = 0, idx = 0;
        while (idx < nums.length - 1) {
            if (idx + nums[idx] >= nums.length - 1) {
                return ans;
            }
            idx += nums[idx];
            ans++;
        }
        return ans;
    }

    public int jump1(int[] nums) {
        int ans = 0, begin = 0, end = 1;
        while (end < nums.length) {
            int temp = 0;
            for (int i = begin; i < end; i++) {
                temp = Math.max(temp, i + nums[i]);
            }
            begin = end;
            end = temp + 1;
            ans++;
        }
        return ans;
    }

    public int jump2(int[] nums) {
        int ans = 0, max = 0, end = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;
    }
}
