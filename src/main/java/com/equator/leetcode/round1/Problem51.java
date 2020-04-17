package com.equator.leetcode.round1;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/1/22 16:43
 **/

public class Problem51 {
    private int n;
    private List<List<String>> ans;
    // 列以及主、副对角线
    private Set<Integer> columnSet;
    private Set<Integer> masterSet;
    private Set<Integer> slaveSet;

    // N皇后 回溯
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        this.n = n;
        ans = new LinkedList<>();
        columnSet = new HashSet<>();
        masterSet = new HashSet<>();
        slaveSet = new HashSet<>();
        backtrace(0, new Stack<>());
        return ans;
    }

    private void backtrace(int row, Stack<Integer> columnState) {
        if (row == n) {
            ans.add(getBoard(columnState));
            return;
        }
        // 遍历每一列
        for (int col = 0; col < n; col++) {
            // 没有冲突
            if (!columnSet.contains(col) && !masterSet.contains(row + col) && !slaveSet.contains(row - col)) {
                columnState.add(col);
                columnSet.add(col);
                masterSet.add(row + col);
                slaveSet.add(row - col);
                backtrace(row + 1, columnState);
                slaveSet.remove(row - col);
                masterSet.remove(row + col);
                columnSet.remove(col);
                columnState.pop();
            }
        }
    }

    private List<String> getBoard(Stack<Integer> columnState) {
        List<String> board = new LinkedList<>();
        for (Integer col : columnState) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append(".");
            }
            builder.replace(col, col + 1, "Q");
            board.add(builder.toString());
        }
        return board;
    }
}
