package com.equator.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/1/17 10:18
 **/

public class Problem88 {
    // 迭代
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        while (p2 < n) {
            if (nums1[p1] == 0 && p1 > m + p2 - 1) {
                nums1[p1++] = nums2[p2++];
            } else if (nums1[p1] <= nums2[p2]) {
                p1++;
            } else {
                for (int i = m + p2 - 1; i >= p1; i--) {
                    nums1[i + 1] = nums1[i];
                }
                nums1[p1++] = nums2[p2++];
            }
        }
    }

    public static void main(String[] args) {
        // int[] num1 = {-1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0}, num2 = {-1, -1, 0, 0, 1, 2};
        int[] num1 = {1, 2, 3, 0, 0, 0}, num2 = {2, 5, 6};
        int m = 3, n = 3;
        new Problem88().merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
}

