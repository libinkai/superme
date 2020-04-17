package com.equator.leetcode.round2.sword;

import java.util.PriorityQueue;

/**
 * @Author: Equator
 * @Date: 2020/3/20 7:30
 **/

public class Solution40 {
    // PriorityQueue 小顶堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (k <= 0 || arr.length < k) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr.length);
        int[] res = new int[k];
        for (int num : arr) {
            heap.add(num);
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
