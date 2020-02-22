package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/22 19:16
 **/

public class Problem46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        char[] charArray = str.toCharArray();
        int n = str.length();
        if (n == 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        if (valid(charArray[0], charArray[1])) {
            dp[1] = 3;
        } else {
            dp[1] = 2;
        }
        for (int i = 2; i < n; i++) {
            dp[i] += dp[i - 1];
            if (valid(charArray[i - 1], charArray[i])) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }

    private boolean valid(char a, char b) {
        Integer val = (a - '0') * 10 + (b - '0');
        if (10 <= val && val <= 25) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem46().translateNum(25));
    }
}
