package com.equator.leetcode.round2;

import com.equator.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/5/10 6:50
 **/

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }
        boolean pInLeft = isExisted(root.left, p);
        boolean qInRight = isExisted(root.right, q);
        if ((pInLeft && qInRight) || (!pInLeft && !qInRight)) {
            return root;
        } else if (pInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (qInRight) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return null;
        }
    }

    private boolean isExisted(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            if (node.val == target.val) {
                return true;
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
            if (node.right != null) {
                stack.addLast(node.right);
            }
        }
        return false;
    }
}
