package com.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/1/23 11:50
 **/

public class Problem455 {
    // 每个孩子最多只能给一块饼干


    // 贪心算法
    public int findContentChildren0(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        int ans = 0, gidx = 0, sidx = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gidx < g.length && sidx < s.length) {
            if (s[sidx] >= g[gidx]) {
                ans++;
                gidx++;
                sidx++;
                if (sidx >= s.length) {
                    return ans;
                }
            } else {
                sidx++;
                if (sidx >= s.length) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[ans]) {
                ans++;
                if (ans >= g.length) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(new Problem455().findContentChildren(g, s));
    }
}
