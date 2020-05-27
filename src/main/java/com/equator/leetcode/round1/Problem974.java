package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.Map;

/** 连续子数组，考虑前缀和试试看
 * @Author: Equator
 * @Date: 2020/5/27 12:07
 **/

public class Problem974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, count = 0;
        for (int a : A) {
            preSum = (preSum + a) % K;
            if (preSum < 0) {
                preSum += K;
            }
            count += map.getOrDefault(preSum, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
