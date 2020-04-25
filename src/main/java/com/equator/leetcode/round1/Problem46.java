package com.equator.leetcode.round1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/4/25 8:17
 **/

public class Problem46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            // 需要拷贝一份数据
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!track.contains(nums[i])) {
                track.add(nums[i]);
                backtrack(nums, track);
                track.removeLast();
            }
        }
    }
}
