package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/4/25 8:17
 **/

public class Problem46_improve1 {
    List<List<Integer>> res = new LinkedList<>();
    boolean[] marked = null;

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        marked = new boolean[nums.length];
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
            if (!marked[i]) {
                marked[i] = true;
                track.add(nums[i]);
                backtrack(nums, track);
                track.removeLast();
                marked[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}
