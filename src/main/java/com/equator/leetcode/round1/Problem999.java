package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/26 18:17
 **/

public class Problem999 {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int rows = board.length, cols = board[0].length, num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'R') {
                    for (int k = i; k >= 0; k--) {
                        if (board[k][j] == 'B') {
                            break;
                        }
                        if (board[k][j] == 'p') {
                            num++;
                            break;
                        }
                    }
                    for (int k = i; k < rows; k++) {
                        if (board[k][j] == 'B') {
                            break;
                        }
                        if (board[k][j] == 'p') {
                            num++;
                            break;
                        }
                    }
                    for (int k = j; k >= 0; k--) {
                        if (board[i][k] == 'B') {
                            break;
                        }
                        if (board[i][k] == 'p') {
                            num++;
                            break;
                        }
                    }
                    for (int k = j; k < cols; k++) {
                        if (board[i][k] == 'B') {
                            break;
                        }
                        if (board[i][k] == 'p') {
                            num++;
                            break;
                        }
                    }
                }
            }
        }
        return num;
    }
}
