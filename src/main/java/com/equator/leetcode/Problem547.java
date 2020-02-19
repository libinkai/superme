package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/29 12:08
 **/

public class Problem547 {

    class DisjointSet {
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
        public int find(int t) {
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

    public int findCircleNum(int[][] M) {
        DisjointSet disjointSet = new DisjointSet(M.length);
        int row = M.length;
        if (row == 0) {
            return 0;
        }
        int col = M[0].length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = i + 1; j < col; j++) {
                if (M[i][j] == 1) {
                    disjointSet.union(i, j);
                }
            }
        }
        return disjointSet.size;
    }
}
