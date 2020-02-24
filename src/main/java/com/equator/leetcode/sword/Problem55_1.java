package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/24 11:27
 **/

public class Problem55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
