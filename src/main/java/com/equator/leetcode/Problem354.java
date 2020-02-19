package com.equator.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Equator
 * @Date: 2020/2/5 15:55
 **/

public class Problem354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    // 信封长度相等
                    return arr1[1] - arr2[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int n = envelopes.length;
        int[] opt = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            opt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    opt[i] = Math.max(opt[i], opt[j] + 1);
                }
            }
            max = Math.max(max, opt[i]);
        }
        return max;
    }
}
