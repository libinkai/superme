package com.equator.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/1/14 8:34
 **/

public class Problem1 {
    // 暴力解法
    public int[] twoSum0(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    // 两遍哈希表
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Integer savedIndex = 0;
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tempMap.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            savedIndex = tempMap.get(nums[i]);
            if (savedIndex != null && savedIndex != i) {
                res[0] = savedIndex;
                res[1] = i;
            }
        }
        return res;
    }

    // 一遍哈希表
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Integer savedIndex = 0;
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 1. 查询
            savedIndex = tempMap.get(nums[i]);
            if (savedIndex != null && savedIndex != i) {
                res[0] = savedIndex;
                res[1] = i;
            }
            // 2. 记录
            // 注意：1与2的顺序不能相反！
            tempMap.put(target - nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(new Problem1().twoSum2(nums, target)));
    }

}
