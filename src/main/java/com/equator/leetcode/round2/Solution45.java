package com.equator.leetcode.round2;

import org.junit.Test;

/**
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @Author: Equator
 * @Date: 2020/5/4 7:15
 **/

public class Solution45 {
    public int jump(int[] nums) {
        // 用 end 表示当前能跳的边界，遇到边界，就更新边界，并且步数加一
        int end = 0, times = 0, max = 0;
        // for 循环中，i < nums.length - 1，少了末尾。因为开始的时候边界是第 0个位置，steps 已经加 1 了
        // 如2 3 1 1 2 2 2，如果最后一步刚好跳到了末尾，此时 steps 其实不用加 1了
        // 如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 1
        for (int i = 0; i < nums.length - 1; i++) {
            // 在可以移动的范围之内，找到最远距离
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                times++;
            }
        }
        return times;
    }

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 1, 99, 1, 7, 5, 44, 33, 22, 33, 44, 2, 5, 1, 42, 1, 34, 64}));
    }
}
