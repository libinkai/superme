package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/20 9:33
 **/

public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 这个判断有点多余
        if (root.left == null && root.right == null) {
            return root;
        }
        /* 错误的写法
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);*/
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
