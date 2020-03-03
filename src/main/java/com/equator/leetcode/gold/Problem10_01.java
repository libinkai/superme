package com.equator.leetcode.gold;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/3 16:14
 **/

public class Problem10_01 {
    // 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B
    public void merge0(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = A.length - 1;
        while (i >= 0 && j >= 0) {
            while (i >= 0 && A[i] >= B[j]) {
                A[k] = A[i];
                i--;
                k--;
            }
            while (j >= 0 && A[i] < B[j]) {
                A[k] = B[j];
                j--;
                k--;
            }
        }
    }

    public void merge(int[] A, int m, int[] B, int n) {
        // 对比选出较大的数放在 m + n - 1 的位置，并将选出此数的指针向前移动
        while (m > 0 && n > 0) {
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        }
        // 剩下的数都比已经遍历过的数小
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n > 0) {
            A[n - 1] = B[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] A = {0};
        int[] B = {1};
        new Problem10_01().merge(A, 0, B, 0);
        System.out.println(Arrays.toString(A));
    }
}
