package com.equator.leetcode.round1.gold;

import com.equator.leetcode.TreeNode;

/**
 * @Author: Equator
 * @Date: 2020/6/1 8:25
 **/

public class Problem04_04 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(deep(root.left) - deep(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deep(root.left) + 1, deep(root.right) + 1);
    }
}
