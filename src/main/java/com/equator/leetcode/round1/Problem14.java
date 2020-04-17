package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/25 10:17
 **/

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //找出最短的单词长度
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minStr = strs[i];
            }
        }
        int i;
        for (i = 0; i < minLen; i++) {
            for (String str : strs) {
                if (str.charAt(i) != minStr.charAt(i)) {
                    // break 只能跳出一层循环
                    return minStr.substring(0, i);
                }
            }
        }
        return minStr.substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new Problem14().longestCommonPrefix(strs));
    }
}
