package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/5/14 7:37
 **/

public class Problem26Better {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        // System.out.println(Arrays.toString(nums));
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                // System.out.println(Arrays.toString(nums));
            }
        }
        return i + 1;
    }

    @Test
    public void test() {
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
    }
}
