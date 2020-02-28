package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/28 18:21
 **/

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    private boolean traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return traverse(p.left, q.left) && traverse(p.right, q.right);
    }
}
