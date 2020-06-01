package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/6/1 8:51
 **/

public class Problem437 {
    private int result = 0, tempSum = 0, sum;

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        tempSum = 0;
        travelPeerNode(root);
        dfs(root.left);
        dfs(root.right);
    }

    private void travelPeerNode(TreeNode root) {
        if (root == null) {
            return;
        }
        tempSum += root.val;
        if (tempSum == sum) {
            result++;
        }
        travelPeerNode(root.left);
        travelPeerNode(root.right);
        tempSum -= root.val;
    }
}
