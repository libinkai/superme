package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/29 12:45
 **/

public class DisjointSet {
    private int size;
    private int[] parents;

    public DisjointSet(int num) {
        parents = new int[num];
        size = num;
        for (int i = 0; i < num; i++) {
            parents[i] = i;
        }
    }

    // 查找指定元素所在集合的领头元素下标
    private int find(int t) {
        while (t != parents[t]) {
            // 缩短路径（可选）
            parents[t] = parents[parents[t]];
            t = parents[t];
        }
        return t;
    }

    // 合并两个集合
    public boolean union(int p, int q) {
        int rp = find(p), rq = find(q);
        if (rp == rq) {
            return false;
        }
        parents[rq] = rp;
        size--;
        return true;
    }
}
