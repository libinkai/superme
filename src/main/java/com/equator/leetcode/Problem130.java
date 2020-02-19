package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/29 12:49
 **/

public class Problem130 {
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

        public boolean isConnected(int p, int q) {
            int rp = find(p), rq = find(q);
            if (rp == rq) {
                return true;
            }
            return false;
        }
    }

    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;
        DisjointSet disjointSet = new DisjointSet(row * col + 1);
        // 一个额外的虚拟的点，边界上所有的O都是其子节点
        int dummyNode = row * col;
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    // 边界上的 O 为一类，其余的各自为主
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        disjointSet.union(i * col + j, dummyNode);
                    } else {
                        for (int k = 0; k < direction.length; k++) {
                            int ni = i + direction[k][0], nj = j + direction[k][1];
                            // board[ni][nj] == 'O' 判断不能少
                            if (0 <= ni && ni < row && 0 <= nj && nj < col && board[ni][nj] == 'O') {
                                disjointSet.union(i * col + j, ni * col + nj);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !disjointSet.isConnected(i * col + j, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
