package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/20 11:19
 **/

public class Problem111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            return minDepth(root.left) + minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
