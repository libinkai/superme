package com.equator.leetcode.round1.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/2/14 22:39
 **/

public class Problem3 {
    // hash time O(n), space O(n)
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[numbers[i]] = temp;
            }
        }
        return false;
    }
}
