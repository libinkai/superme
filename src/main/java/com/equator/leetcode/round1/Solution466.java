package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/4/19 11:36
 **/

public class Solution466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if ("".equals(s1) || n1 == 0) {
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = s1.length(), len2 = s2.length();
        // 记录每一次s1扫描结束后当前的状态，寻找循环
        Map<Integer, int[]> map = new HashMap<>();
        // 经历多少s1与s2
        int count1 = 0, count2 = 0;
        int p = 0;
        while (count1 < n1) {
            for (int i = 0; i < len1; i++) {
                if (chars1[i] == chars2[p]) {
                    p++;
                    if (p == len2) {
                        p = 0;
                        count2++;
                    }
                }
            }
            count1++;
            if (!map.containsKey(p)) {
                map.put(p, new int[]{count1, count2});
            } else {
                int[] last = map.get(p);
                int circle1 = count1 - last[0], circle2 = count2 - last[1];
                count2 += circle2 * ((n1 - count1) / circle1);
                count1 = count1 + ((n1 - count1) / circle1) * circle1;
            }
        }
        return count2 / n2;
    }
}
