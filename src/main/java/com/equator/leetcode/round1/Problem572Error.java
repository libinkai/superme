package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/5/7 7:35
 **/

public class Problem572Error {
    // 如果一棵树中有重复数字就不行了
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private void travel(TreeNode root, TreeNode t) {

    }
}
