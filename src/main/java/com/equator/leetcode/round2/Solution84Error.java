package com.equator.leetcode.round2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/30 17:33
 **/

public class Solution84Error {
    // 双指针 要平整
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE, low = 0, high = heights.length - 1;
        while (low < high) {
            int curArea = (high - low + 1) * Math.min(heights[low], heights[high]);
            maxArea = Math.max(maxArea, curArea);
            if (heights[low] > heights[high]) {
                high--;
            } else {
                low++;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        Assert.assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
