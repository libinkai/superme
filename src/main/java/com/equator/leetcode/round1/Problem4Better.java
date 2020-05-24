package com.equator.leetcode.round1;

/**
 * 算法的时间复杂度为 O(log(m + n))
 *
 * @Author: Equator
 * @Date: 2020/5/24 10:35
 **/

public class Problem4Better {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        // 将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) / 2.0;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 （传递一层）
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 为了防止数组长度小于 k/2，所以每次比较 min(k/2，len(数组) 对应的数字
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
