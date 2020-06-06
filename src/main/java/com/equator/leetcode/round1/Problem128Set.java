package com.equator.leetcode.round1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/6/6 10:01
 **/

public class Problem128Set {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 长度一般都不会是负数，所以最小值可以设定为0，可以免去特判
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cnt = 0;
                int cur = num;
                while (set.contains(cur)) {
                    cnt++;
                    cur++;
                }
                maxLen = Math.max(maxLen, cnt);
            }
        }
        return maxLen;
    }
}
