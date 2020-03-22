package com.equator.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/22 8:08
 **/

public class Problem945 {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            if (diff <= 0) {
                res += (A[i - 1] + 1 - A[i]);
                A[i] = A[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7};
        System.out.println(new Problem945().minIncrementForUnique(nums));
    }
}
