package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 12:13
 **/

public class Problem67 {
    public int strToInt(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int res = 0;
        int i = 0;
        int flag = 1;
        // 1. 检查空格
        while (i < len && chars[i] == ' ') {
            i++;
        }
        // 2. 检查符号
        if (i < len && chars[i] == '-') {
            flag = -1;
        }
        // 这里的处理也太妙了
        if (i < len && (chars[i] == '+' || chars[i] == '-')) {
            i++;
        }
        // 3. 计算数字
        while (i < chars.length && '0' <= chars[i] && chars[i] <= '9') {
            int r = chars[i] - '0';
            // ------ 4. 处理溢出，这是关键步骤 ------
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 左移一位，妙！
            res = res * 10 + r;
            i++;
        }
        return flag > 0 ? res : -res;
    }

    // 过于复杂、没意思、缝缝补补
    public int strToIntBad(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        // 一遍扫描获取整数的位数
        boolean died = false;
        int len = 0;
        int idx = 0;
        int sign = 1;
        for (int i = 0; i < chars.length; i++) {
            if ('-' == chars[i]) {
                if (died) {
                    return 0;
                }
                sign = -1;
                idx++;
                died = true;
                continue;
            } else if ('+' == chars[i]) {
                if (died) {
                    return 0;
                }
                idx++;
                died = true;
                continue;
            }
            if ('0' <= chars[i] && chars[i] <= '9') {
                if (died == false) {
                    died = true;
                }
                len++;
            } else {
                break;
            }
        }
        if (len == 0) {
            return 0;
        }
        long res = 0;
        for (int i = len - 1; i >= 0; i--) {
            int r = chars[idx] - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            idx++;
        }
        return (int) (sign * res);
    }

    public static void main(String[] args) {
        System.out.println(new Problem67().strToInt("    --10"));
    }
}
