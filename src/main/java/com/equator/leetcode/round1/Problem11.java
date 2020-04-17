package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/14 10:00
 **/

public class Problem11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0, tempArea = 0, h, w;
        while (i < j) {
            h = height[i] < height[j] ? height[i++] : height[j--];
            w = j - i + 1;
            tempArea = w * h;
            maxArea = Math.max(tempArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Problem11().maxArea(height));
    }
}
