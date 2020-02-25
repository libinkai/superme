package com.equator.leetcode.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/25 10:00
 **/

public class Problem57_2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, mid = (1 + target) / 2;
        int cur = left + right;
        List<int[]> res = new ArrayList<>();
        while (left < mid) {
            if (cur == target) {
                append(res, left, right);
            }
            while (cur > target && left < mid) {
                cur -= left;
                left++;
                if (cur == target) {
                    append(res, left, right);
                }
            }
            right++;
            cur += right;
        }
        return res.toArray(new int[0][]);
    }

    private void append(List<int[]> res, int left, int right) {
        int idx = 0;
        int[] item = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            item[idx] = i;
            idx++;
        }
        res.add(item);
    }

    public static void main(String[] args) {
        int[][] arr = new Problem57_2().findContinuousSequence(15);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
