package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/29 8:54
 **/

public class Problem79 {

    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int row, col;
    private char[][] board;
    private boolean[][] marked;
    private String word;

    public boolean exist(char[][] board, String word) {
        // 搜索，遍历字符矩阵
        row = board.length;
        if (row == 0) {
            return false;
        }
        col = board[0].length;
        this.board = board;
        this.word = word;
        // 遍历标记
        marked = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (travel(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean travel(int x, int y, int idx) {
        if (idx == word.length() - 1) {
            return board[x][y] == word.charAt(idx);
        }
        if (word.charAt(idx) == board[x][y]) {
            marked[x][y] = true;
            for (int i = 0; i < direction.length; i++) {
                int nx = x + direction[i][0], ny = y + direction[i][1];
                if (0 <= nx && nx < row && 0 <= ny && ny < col && !marked[nx][ny]) {
                    if (travel(nx, ny, idx + 1)) {
                        return true;
                    }
                }
            }
            marked[x][y] = false;
        }
        return false;
    }

    // 回溯（没有剪枝，超出时间限制）
    /*public boolean exist(char[][] board, String word) {
        // 搜索，遍历字符矩阵
        row = board.length;
        if (row == 0) {
            return false;
        }
        col = board[0].length;
        // 遍历标记
        boolean[][] marked = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (travel(board, marked, word, i, j, "")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean travel(char[][] board, boolean[][] marked, String word, int x, int y, String cur) {
        marked[x][y] = true;
        cur += board[x][y];
        if (word.equals(cur)) {
            return true;
        }
        for (int i = 0; i < direction.length; i++) {
            int nx = x + direction[i][0], ny = y + direction[i][1];
            if (0 <= nx && nx < row && 0 <= ny && ny < col && !marked[nx][ny]) {
                if (travel(board, marked, word, nx, ny, cur)) {
                    return true;
                }
            }
        }
        marked[x][y] = false;
        return false;
    }*/


}
