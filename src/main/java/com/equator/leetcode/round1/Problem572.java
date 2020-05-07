package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/5/7 7:35
 **/

public class Problem572 {
    // 判断 t 是否为 s 的子树是或的关系：当前两棵树相等；或者s的左子树和t相等；或者s的左子树和t相等
    // 判断两个树是否相等是与的关系：当前两个树的根节点值相等；并且s的左子树和t的左子树相等；并且s的左子树和t的右子树相等
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
