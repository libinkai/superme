package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/24 10:26
 **/

public class Problem54 {
    // BST 中序遍历的两种方式
    private int k;

    public int kthLargest(TreeNode root, int k) {
        if (k <= 0) {
            return 0;
        }
        this.k = k;
        int[] res = new int[1];
        rec(root, res);
        return res[0];
    }

    private void rec(TreeNode root, int[] res) {
        if (root.right != null) {
            rec(root.right, res);
        }
        if (k == 1) {
            res[0] = root.val;
            k--;
            return;
        }
        k--;
        if (root.left != null) {
            rec(root.left, res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        System.out.println(new Problem54().kthLargest(root, 1));
    }
}
