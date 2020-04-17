package com.equator.leetcode.round1.sword;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/2/25 7:49
 **/

public class Problem56_2 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int mask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & mask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                mask <<= 1;
            }
        }
        // 如何用bit拼接一个整数？移位+相加
        int result = 0;
        // 从高位开始
        for (int i = 0; i < 32; i++) {
            System.out.println(i + " " + Integer.toBinaryString(result));
            result <<= 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 3};
        System.out.println(new Problem56_2().singleNumber(nums));
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 3, 3};
        int result = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(i + " " + Integer.toBinaryString(result));
            result <<= 1;
            result += nums[i] % 3;
            System.out.println(i + " " + Integer.toBinaryString(result));
        }
        System.out.println(result);
        System.out.println("-----------------");
        result = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(i + " " + Integer.toBinaryString(result));
            result += nums[i] % 3;
            result <<= 1;
            System.out.println(i + " " + Integer.toBinaryString(result));
        }
        System.out.println(result);
    }
}
