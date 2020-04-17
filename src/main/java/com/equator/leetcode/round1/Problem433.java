package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/22 20:54
 **/

public class Problem433 {
    // 错误得解法，每次变异得过程都需要在基因库中
    public int minMutation(String start, String end, String[] bank) {
        boolean able = false;
        for (String s : bank) {
            if (s.equals(end)) {
                able = true;
            }
        }
        if (!able) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
