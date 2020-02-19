package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/16 9:46
 **/

public class Problem13 {
    private int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int num = 0, m = 0, n = 0, k = 0;
    boolean[][] traveled = null;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        traveled = new boolean[m][n];
        travel(0, 0);
        return num;
    }

    public void travel(int x, int y) {
        num++;
        traveled[x][y] = true;
        for (int i = 0; i < vector.length; i++) {
            int nx = x + vector[i][0], ny = y + vector[i][1];
            if (canArrive(nx, ny) && !traveled[nx][ny]) {
                travel(nx, ny);
            }
        }
    }

    public boolean canArrive(int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n && digitSum(x) + digitSum(y) <= k) {
            return true;
        }
        return false;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem13().movingCount(1, 1, 1));
    }
}
