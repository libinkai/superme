package com.equator.leetcode.round1.gold;

/**
 * @Author: Equator
 * @Date: 2020/3/16 16:30
 **/

public class Problem01_06 {
    public String compressString(String S) {
        if (S == null || "".equals(S)) {
            return "";
        }
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(count);
                sb.append(chars[i]);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        return sb.length() >= S.length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem01_06().compressString("aaabbbhhhkkkddddddddd"));
        System.out.println(new Problem01_06().compressString("aabcccccaaa"));
        System.out.println(new Problem01_06().compressString("abbccd"));
    }
}
