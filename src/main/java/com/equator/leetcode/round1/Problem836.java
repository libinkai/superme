package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/18 18:53
 **/

public class Problem836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return judge(rec1, rec2) && judge(rec2, rec1);
    }

    public boolean judge(int[] rec1, int[] rec2) {
        if (rec1[2] <= rec2[0]) {
            return false;
        }
        if (rec1[0] >= rec2[2]) {
            return false;
        }
        if (rec1[1] >= rec2[3]) {
            return false;
        }
        if (rec1[3] <= rec2[1]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] rec1 = {0, 0, 2, 2}, rec2 = {1, 1, 3, 3};
        // int[] rec1 = {0, 0, 1, 1}, rec2 = {1, 0, 2, 1};
        System.out.println(new Problem836().isRectangleOverlap(rec1, rec2));
    }
}
