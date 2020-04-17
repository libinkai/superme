package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/25 12:21
 **/

public class Problem58_1 {
    public String reverseWords0(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        // 确保字符串前后没有空格
        s = s.trim();
        char[] chars = reverse(s.toCharArray(), 0, s.length() - 1);
        int start = 0, end = 0, len = chars.length;
        while (end < len) {
            while (end < len && chars[end] != ' ') {
                end++;
            }
            reverse(chars, start, end - 1);
            if (end >= len) {
                break;
            }
            while (chars[end] == ' ') {
                end++;
            }
            start = end;
        }
        return new String(chars);
    }

    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                sb.append(strs[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    private char[] reverse(char[] chars, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(new Problem58_1().reverseWords("the sky       is blue"));
    }
}
