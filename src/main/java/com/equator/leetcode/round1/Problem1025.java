package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/28 11:53
 **/

public class Problem1025 {
    public boolean divisorGame(int N) {
        int count = 0;
        while (N > 1) {
            // for (int i = (int) Math.sqrt(N); i >= 1; i--) 最佳状态应该是从1（最小的）开始
            for (int i = 1; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    count++;
                    N -= i;
                    break;
                }
            }
        }
        return count % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1025().divisorGame(2));
    }
}
