package com.equator.leetcode.round2;

import javafx.scene.control.Alert;
import org.junit.Assert;
import org.junit.Test;

/**
 * 暴力法，中间向两边拓展，比当前柱子高的话就继续走
 *
 * @Author: Equator
 * @Date: 2020/5/30 17:33
 **/

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int w = 1, h = heights[i];
            for (int j = i - 1; j >= 0 && heights[j] >= h; j--) {
                w++;
            }
            for (int j = i + 1; j < heights.length && heights[j] >= h; j++) {
                w++;
            }
            maxArea = Math.max(maxArea, w * h);
        }
        return maxArea;
    }

    @Test
    public void test() {
        Assert.assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(9, largestRectangleArea(new int[]{0, 9}));
    }
}
