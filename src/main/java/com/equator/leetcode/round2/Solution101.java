package com.equator.leetcode.round2;

import com.equator.leetcode.TreeNode;

/**
 * @Author: Equator
 * @Date: 2020/5/31 8:30
 **/

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricEqual(root.left, root.right);
    }

    private boolean symmetricEqual(TreeNode left, TreeNode right) {
        if (left != null && right != null && left.val == right.val) {
            return symmetricEqual(left.left, right.right) && symmetricEqual(left.right, right.left);
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }
}
