package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/29 12:51
 **/

public class Problem200 {
    class DisjointSet {
        private int size;
        private int[] parents;

        public DisjointSet(char[][] grid, int row, int col) {
            parents = new int[row * col];
            int sum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    parents[i * col + j] = i * col + j;
                    if (grid[i][j] == '1') {
                        sum++;
                    }
                }
            }
            size = sum;
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

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        DisjointSet disjointSet = new DisjointSet(grid, row, col);
        boolean[][] marked = new boolean[row][col];
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                marked[i][j] = true;
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < direction.length; k++) {
                    int ni = i + direction[k][0], nj = j + direction[k][1];
                    if (0 <= ni && ni < row && 0 <= nj && nj < col && grid[ni][nj] == '1') {
                        // System.out.printf("i=%d,j=%d,ni=%d,nj=%d,flag=%b\n", i, j, ni, nj, disjointSet.union(i * col + j, ni * col + nj));
                        disjointSet.union(i * col + j, ni * col + nj);
                    }
                }
            }
        }
        return disjointSet.size;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Problem200().numIslands(grid));
    }
}
