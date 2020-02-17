package com.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/17 21:00
 **/

public class Problem17 {
    public int[] printNumbers(int n) {
        int[] map = {10, 100, 1000, 1_0000, 10_0000, 100_0000, 1000_0000, 1_0000_0000, 10_0000_0000, Integer.MAX_VALUE};
        int size = map[n - 1];
        int[] ans = new int[size - 1];
        for (int i = 1; i < size; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
