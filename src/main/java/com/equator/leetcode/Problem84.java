package com.equator.leetcode;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/1/18 10:23
 **/

public class Problem84 {
    // 错误的解法，与最大容器不一样，这个中间要平整
    public int largestRectangleArea0(int[] heights) {
        int i = 0, j = heights.length - 1;
        int w, h, maxArea = 0, tempArea = 0;
        while (i <= j) {
            w = j - i + 1;
            h = heights[i] < heights[j] ? heights[i++] : heights[j--];
            tempArea = w * h;
            maxArea = Math.max(maxArea, tempArea);
        }
        return maxArea;
    }

    // 暴力
    public int largestRectangleArea1(int[] heights) {
        int minHeight, width, maxArea = 0, tempArea;
        for (int i = 0; i < heights.length; i++) {
            minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                if (heights[j] < minHeight) {
                    minHeight = heights[j];
                }
                width = j - i + 1;
                tempArea = minHeight * width;
                maxArea = Math.max(maxArea, tempArea);
            }
        }
        return maxArea;
    }

    // 栈
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        // 创建一个栈来保存下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new Problem84().largestRectangleArea1(heights));
    }
}
