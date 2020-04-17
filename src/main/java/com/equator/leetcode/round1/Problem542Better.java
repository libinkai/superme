package com.equator.leetcode.round1;

import com.equator.leetcode.round1.util.ArrayPrinter;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Tree是有向的因此不需要标识是否访问过，而对于无向图来说，必须得标志是否访问过。并且为了防止某个节点多次入队，需要在其入队之前就将其设置成已访问！
 *
 * @Author: Equator
 * @Date: 2020/4/15 7:53
 **/

public class Problem542Better {
    int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        // 首先把每个源点 0 入队，然后从各个 0 同时开始一圈一圈的向 1扩散（每个 1 都是被离它最近的 0 扩散到的 ）
        Deque<Pair<Integer, Integer>> nodes = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    nodes.addLast(new Pair<>(i, j));
                } else {
                    // 先把 matrix 数组中 1 的位置设置成 -1，表示未访问
                    matrix[i][j] = -1;
                }
            }
        }
        while (!nodes.isEmpty()) {
            Pair<Integer, Integer> node = nodes.pollFirst();
            int x = node.getKey(), y = node.getValue();
            for (int i = 0; i < delta.length; i++) {
                int nx = x + delta[i][0], ny = y + delta[i][1];
                if (0 <= nx && nx < rows && 0 <= ny && ny < cols && matrix[nx][ny] == -1) {
                    matrix[nx][ny] = matrix[x][y] + 1;
                    nodes.addLast(new Pair<>(nx, ny));
                }
            }
        }
        return matrix;
    }


    @Test
    public void main() {
        // int[][] arr = {};
        // int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(ArrayPrinter.print(new Problem542Better().updateMatrix(arr)));
    }
}
