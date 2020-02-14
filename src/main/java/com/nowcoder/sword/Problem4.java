package com.nowcoder.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/14 23:21
 **/

public class Problem4 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
            return false;
        }
        int row = array.length, col = array[0].length;
        for (int i = 0; i < row; i++) {
            if (target < array[i][col - 1]) {
                for (int j = 0; j < col; j++) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            } else if (target > array[i][col - 1]) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}};
        System.out.println(new Problem4().Find(2, arr));
    }
}
