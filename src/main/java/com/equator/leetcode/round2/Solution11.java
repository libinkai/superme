package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/4/18 11:13
 **/

public class Solution11 {
    public int maxArea0(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            // 双指针往中间收敛，难点是怎么移动呢？
            // 在宽度不断缩小的情况下，柱子的高度是一个优势，所以每次挪动矮的柱子下标
            int h = height[i] < height[j] ? height[i++] : height[j--];
            // 为什么是 j-i+1呢？因为上面的i++，j--先走了一步，那是下一轮的下标
            int area = (j - i + 1) * h;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[i++]);
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[j--]);
            }
        }
        return maxArea;
    }
}
