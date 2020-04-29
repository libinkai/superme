package com.equator.leetcode.round2.sword;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/4/28 8:21
 **/

public class Solution56_1 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int zeroNum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            sum ^= num;
            if (num == 0) {
                zeroNum++;
            }
        }
        if (zeroNum == 1) {
            return new int[]{sum, 0};
        }
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int lowSum = 0, highSum = 0;
            for (int num : nums) {
                if (num <= mid) {
                    lowSum ^= num;
                } else {
                    highSum ^= num;
                }
            }
            if (lowSum != 0 && highSum != 0) {
                return new int[]{lowSum, highSum};
            }
            if (lowSum == 0) {
                // 说明 p 和 q 都比 mid 大，所以比 mid 小的数的异或和变为0了
                low = mid;
            } else {
                high = mid;
            }
        }
        return null;
    }

    @Test
    public void test() {
        int low = -6, high = 3;
        System.out.println((low + high) >> 1);
        System.out.println(low + (high - low) / 2);
    }
}
