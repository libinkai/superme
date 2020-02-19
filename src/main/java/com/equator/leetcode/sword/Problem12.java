package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/16 7:45
 **/

public class Problem12 {
    private int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private char[][] board = null;
    private int rows = 0, cols = 0;
    private char[] words = null;
    boolean[][] traveled = null;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || "".equals(word)) {
            return false;
        }
        this.board = board;
        this.words = word.toCharArray();
        rows = board.length;
        cols = board[0].length;
        traveled = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 剪枝
                if (travel(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean travel(int x, int y, int idx) {
        if (idx == words.length - 1) {
            return board[x][y] == words[idx];
        }
        if (board[x][y] == words[idx]) {
            traveled[x][y] = true;
            for (int i = 0; i < vector.length; i++) {
                int nx = x + vector[i][0], ny = y + vector[i][1];
                if (0 <= nx && nx < rows && 0 <= ny && ny < cols && !traveled[nx][ny]) {
                    if (travel(nx, ny, idx + 1)) {
                        return true;
                    }
                }
            }
            traveled[x][y] = false;
        }
        return false;
    }
}
