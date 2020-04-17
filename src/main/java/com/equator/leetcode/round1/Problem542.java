package com.equator.leetcode.round1;

import com.equator.leetcode.round1.util.ArrayPrinter;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 超时
 * @Author: Equator
 * @Date: 2020/4/15 7:53
 **/

public class Problem542 {
    int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] matrix = null, dist = null;
    int rows = 0, cols = 0;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
        this.dist = new int[rows][cols];
        // 保存非0节点
        List<Pair<Integer, Integer>> nodes = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    nodes.add(new Pair<>(i, j));
                }
            }
        }
        for (Pair<Integer, Integer> node : nodes) {
            bfs(node.getKey(), node.getValue());
        }
        return dist;
    }

    private void bfs(int x, int y) {
        boolean[][] marked = new boolean[rows][cols];
        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(x, y));
        int depth = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                Pair<Integer, Integer> node = queue.pollFirst();
                int cx = node.getKey(), cy = node.getValue();
                marked[cx][cy] = true;
                if (matrix[cx][cy] == 0) {
                    dist[x][y] = depth;
                    return;
                }
                for (int j = 0; j < delta.length; j++) {
                    int nx = cx + delta[j][0], ny = cy + delta[j][1];
                    if (0 <= nx && nx < rows && 0 <= ny && ny < cols && !marked[nx][ny]) {
                        queue.addLast(new Pair<>(nx, ny));
                    }
                }
            }
            depth++;
        }
    }

    @Test
    public void main() {
        int[][] arr = {};
        // int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        //int[][] arr = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(ArrayPrinter.print(new Problem542().updateMatrix(arr)));
    }
}
