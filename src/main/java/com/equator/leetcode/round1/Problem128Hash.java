package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/6/6 10:01
 **/

public class Problem128Hash {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 长度一般都不会是负数，所以最小值可以设定为0，可以免去特判
        int maxLen = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int leftLen = map.getOrDefault(num - 1, 0);
                int rightLen = map.getOrDefault(num + 1, 0);
                int len = leftLen + 1 + rightLen;
                maxLen = Math.max(maxLen, len);
                map.put(num, len);
                map.put(num - leftLen, len);
                map.put(num + rightLen, len);
            }
        }
        return maxLen;
    }
}
