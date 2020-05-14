package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/5/14 7:37
 **/

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                continue;
            } else {
                int start = i, end = i;
                for (int j = start; j < size - 1; j++) {
                    if (nums[j] == nums[j + 1]) {
                        end++;
                    } else {
                        break;
                    }
                }
                int delta = end - start;
                for (int j = end + 1; j < size; j++) {
                    nums[j - delta] = nums[j];
                }
                size -= delta;
            }
        }
        return size;
    }

    @Test
    public void test() {
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
    }
}
