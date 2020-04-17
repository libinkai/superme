package com.equator.leetcode.round1.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/2/25 15:34
 **/

public class Problem59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 队伍左边元素最大
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // 是否超出窗口
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 窗口开始滑动了吗
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
