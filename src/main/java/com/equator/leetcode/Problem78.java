package com.equator.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/22 8:33
 **/

public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> ans = new LinkedList<>();
        dr(nums, ans, new LinkedList<>(), 0);
        return ans;
    }

    public void dr(int[] nums, List<List<Integer>> ans, List<Integer> ansItem, int idx) {
        if (idx == nums.length) {
            ans.add(new LinkedList<>(ansItem));
            return;
        }
        dr(nums, ans, ansItem, idx + 1);
        ansItem.add(nums[idx]);
        dr(nums, ans, ansItem, idx + 1);
        ansItem.remove(ansItem.size() - 1);
    }
}
