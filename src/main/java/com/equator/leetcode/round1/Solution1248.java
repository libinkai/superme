package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/4/21 15:55
 **/

public class Solution1248 {
    /**
     * 假设当前遍历到i,前缀和sum：
     * sum=nums[0]+nums[1]+...+nums[j]+nums[j+1]+...+nums[i]
     * 若存在前缀和sum-k:
     * sum-k=nums[0]+nums[1]+...+nums[j]
     * 则一定存在子序列和k：
     * k=nums[j+1]+nums[j+2]+...+nums[i]
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        // sum 前缀和 即到当前元素为止，数组中有多少个奇数
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += (num & 1);
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }


    @Test
    public void test() {
        int[] nums = {1, 1, 2, 1, 1};
        System.out.println(numberOfSubarrays(nums, 3));
    }
}
