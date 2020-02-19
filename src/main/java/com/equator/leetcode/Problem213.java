package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/5 7:07
 **/

public class Problem213 {
    public int cal(int[] nums, int start, int end) {
        // 定义opt[i]为盗贼在前i栋房子最多偷多少枚金币
        // opt[i] = max {opt[i-1],opt[i-2]+nums[i-1]}
        int old = 0; // opt[0]
        int now = nums[start]; // opt[1]
        for (int i = start + 2; i <= end + 1; i++) {
            // old = opt[i-2] now = opt[i-1]
            int t = Math.max(now, old + nums[i - 1]);
            old = now;
            now = t;
        }
        return now;
    }

    // 破圈
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 没偷房子0
        int withoutHeader = Math.max(Integer.MIN_VALUE, cal(nums, 1, nums.length - 1));
        // 没偷房子n-1
        int withHeader = Math.max(Integer.MIN_VALUE, cal(nums, 0, nums.length - 2));
        return Math.max(withHeader, withoutHeader);
    }
}
