package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/10 17:29
 **/

public class Problem543 {
    // 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点
    // 一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    // 求节点深度
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
