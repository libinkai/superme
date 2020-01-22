package com.leetcode;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/1/20 17:01
 **/

public class Problem236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pAncestor = new Stack<>();
        Stack<TreeNode> qAncestor = new Stack<>();
        return null;
    }

    public void travel(Stack<TreeNode> ancestor, TreeNode root, TreeNode target) {
        if (root != null) {
            if (root.equals(target)) {
                return;
            }
            travel(ancestor, root.left, target);
            ancestor.add(root);
            travel(ancestor, root.right, target);
        }
    }
}
