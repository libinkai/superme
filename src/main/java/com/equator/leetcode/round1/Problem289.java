package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/4/2 16:36
 **/

public class Problem289 {
    int[][] dxy = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, -0}, {-1, 1}};
    int[][] board;
    int m, n;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = countAlive(i, j);
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countAlive(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < dxy.length; i++) {
            int nx = x + dxy[i][0], ny = y + dxy[i][1];
            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                cnt += (board[nx][ny] & 1);
            }
        }
        return cnt;
    }
}
