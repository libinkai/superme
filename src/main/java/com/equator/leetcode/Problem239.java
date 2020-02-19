package com.equator.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Equator
 * @Date: 2020/1/18 17:48
 **/

public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekLast() <= i - k) {
                queue.pollLast();
            }
            if (i + 1 > k) {
                ans[i + 1 - k] = nums[queue.peek()];
            }
        }
        return ans;
    }
}
