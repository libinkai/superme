package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/4/3 20:55
 **/

public class Problem8 {
    public int myAtoi(String str) {
        if ("".equals(str) || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int idx = 0, flag = 1, len = chars.length;
        while (idx < len && chars[idx] == ' ') {
            idx++;
        }
        if (idx < len && chars[idx] == '-') {
            flag = -1;
        }
        if (idx < len && (chars[idx] == '-' || chars[idx] == '+')) {
            idx++;
        }
        int sum = 0;
        while (idx < len) {
            int r = chars[idx] - '0';
            if (chars[idx] < '0' || chars[idx] > '9') {
                return flag * sum;
            }
            if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE / 10 && r > 7) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + r;
            idx++;
        }
        return flag * sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Problem8().myAtoi("-+1"));
    }
}
