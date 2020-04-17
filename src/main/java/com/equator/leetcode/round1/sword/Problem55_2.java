package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/24 11:59
 **/

public class Problem55_2 {
    private int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = rec(root.left);
        int right = rec(root.right);
        if (left != -1 && right != -1 && Math.abs(left - right) < 2) {
            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }
        return -1;
    }

    public boolean isBalanced(TreeNode root) {
        return rec(root) == -1 ? false : true;
    }
}
