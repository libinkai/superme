package com.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/1/14 8:18
 **/

public class Problem283 {
    public void moveZeroes0(int[] nums) {
        int zerosCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zerosCounter++;
            } else {
                int temp = nums[i - zerosCounter];
                nums[i - zerosCounter] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        // 下一个非零值要放的下标
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Problem283().moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
