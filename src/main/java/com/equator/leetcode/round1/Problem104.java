package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/20 11:16
 **/

public class Problem104 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
