package com.leetcode;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/1/19 10:10
 **/

public class Problem42 {
    public int trap(int[] height) {
        int capacity = 0, top, w, h;
        // 保存下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                top = stack.pop();
                // 前面没有左边界
                if (stack.isEmpty()) {
                    break;
                }
                w = i - stack.peek() - 1;
                h = Math.min(height[i], height[stack.peek()]) - height[top];
                capacity += w * h;
            }
            stack.push(i);
        }
        return capacity;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 0, 2};
        System.out.println(new Problem42().trap(heights));
        ;
    }

}
