package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * 二分法 抽屉原理
 *
 * @Author: Equator
 * @Date: 2020/5/26 9:06
 **/

public class Problem287 {
    public int findDuplicate(int[] nums) {
        // 不是数组下标而是数字的区间
        int left = 1, right = nums.length - 1;
        while (left < right) {
            // 当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test1() {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
