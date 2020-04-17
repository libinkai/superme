package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 15:25
 **/

public class Problem68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > root.val && q.val > root.val) {
            System.out.println("a");
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            System.out.println("b");
            return lowestCommonAncestor(root.left, p, q);
        } else {
            System.out.println("c");
            return root;
        }
    }
}
