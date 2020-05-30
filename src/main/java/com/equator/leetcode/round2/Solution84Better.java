package com.equator.leetcode.round2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 * 遍历每个柱体，若当前的柱体高度大于等于栈顶柱体的高度，就直接将当前柱体入栈。
 * 否则若当前的柱体高度小于栈顶柱体的高度，说明当前栈顶柱体找到了右边的第一个小于自身的柱体，那么就可以将栈顶柱体出栈来计算以其为高的矩形的面积了
 *
 * @Author: Equator
 * @Date: 2020/5/30 17:33
 **/

public class Solution84Better {
    public int largestRectangleArea(int[] heights) {
        // 前后增加两个高度为0的柱体其实是起到了“哨兵”💂的作用
        int[] arr = new int[heights.length + 2];
        System.arraycopy(heights, 0, arr, 1, heights.length);
        int maxArea = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[i] < arr[deque.peekFirst()]) {
                // deque弹出之后，栈顶元素就是左边第一个比他小的元素啦
                int h = arr[deque.pollFirst()], w = i - deque.peekFirst() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            deque.addFirst(i);
        }
        return maxArea;
    }

    @Test
    public void test() {
        Assert.assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(9, largestRectangleArea(new int[]{0, 9}));
    }
}
