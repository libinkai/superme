package com.equator.leetcode.round1.sword;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/26 7:25
 **/

public class Problem61 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        Arrays.sort(nums);
        int numberOfZero = 0, discontinuity = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numberOfZero++;
                continue;
            }
            // 出现对子
            if (i > 0 && nums[i] != 0 && nums[i] == nums[i - 1]) {
                return false;
            }
            if (i > 0 && nums[i] != 0 && nums[i - 1] != 0 && nums[i] != nums[i - 1] + 1) {
                discontinuity += nums[i] - nums[i - 1] - 1;
            }
        }
        if (discontinuity == 0 || numberOfZero >= discontinuity) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 8, 5, 4};
        System.out.println(new Problem61().isStraight(nums));
    }
}
