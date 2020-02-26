package com.equator.leetcode.sword;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/26 15:56
 **/

public class Problem68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /*private Deque<TreeNode> findPath(TreeNode root, TreeNode target) {
        Deque<TreeNode> path = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            path.push(pop);
            if (pop.val == target.val) {
                return path;
            } else {
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }
        }
        return path;
    }

    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> more = findPath(root, p);
        System.out.println("---");
        Deque<TreeNode> less = findPath(root, q);
        if (more.size() < less.size()) {
            Deque<TreeNode> temp = more;
            more = less;
            less = temp;
        }
        System.out.println("more:" + more.size() + "less:" + less.size());
        while (!more.isEmpty() && more.size() != less.size()) {
            System.out.println("more:" + more.pollLast());
        }
        while (!more.isEmpty() && !more.peekLast().equals(less.peekLast())) {
            System.out.println("more:" + more.pollLast() + "less:" + less.pollLast());
        }
        return more.pollLast();
    }*/
}
