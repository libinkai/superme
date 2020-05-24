package com.equator.leetcode.round1;

/**
 * 不满足要求，要求算法的时间复杂度为 O(log(m + n))
 *
 * @Author: Equator
 * @Date: 2020/5/24 10:35
 **/

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1, nums2);
        int len = result.length;
        if (len % 2 == 1) {
            return result[len / 2];
        } else {
            return (result[len / 2] + result[len / 2 - 1]) / 2.0;
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] result = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            result[k++] = nums1[i++];
        }
        while (j < len2) {
            result[k++] = nums2[j++];
        }
        return result;
    }
}
