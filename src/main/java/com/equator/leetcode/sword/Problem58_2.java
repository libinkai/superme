package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/25 15:24
 **/

public class Problem58_2 {
    public String reverseLeftWords(String s, int n) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
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
        System.out.println(new Problem58_2().reverseLeftWords("abcdefg",2));
    }
}
