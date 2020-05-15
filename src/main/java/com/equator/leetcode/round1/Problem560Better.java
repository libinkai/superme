package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 *
 * @Author: Equator
 * @Date: 2020/5/15 7:56
 **/

public class Problem560Better {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int preSum = 0;
        for (int num : nums) {
            // preSum 有可能增加，也有可能减少
            preSum += num;
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
