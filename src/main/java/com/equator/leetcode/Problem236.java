package com.equator.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/20 17:01
 **/

public class Problem236 {
    // 递归遍历左右子树，如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先；如果左右子树其中一个不为空，则返回非空节点。
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor0(root.left, p, q);
        TreeNode right = lowestCommonAncestor0(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // 回溯法，虽然dfs的返回值在主函数没用到，但是递归的时候有用（直观的解法，找到一条路径，再寻找路径的最后一个公共节点）
    private boolean dfs(TreeNode root, TreeNode target, Deque<TreeNode> path) {
        if (root.equals(target)) {
            path.addLast(root);
            return true;
        }
        path.addLast(root);
        if (root.left != null && dfs(root.left, target, path)) {
            return true;
        }
        if (root.right != null && dfs(root.right, target, path)) {
            return true;
        }
        path.pollLast();
        return false;
    }

    // 回溯
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> list1 = new LinkedList<>();
        dfs(root, p, list1);
        Deque<TreeNode> list2 = new LinkedList<>();
        dfs(root, q, list2);
        TreeNode common = null;
        while (list1.size() > 0 && list2.size() > 0) {
            TreeNode node1 = list1.pollFirst();
            TreeNode node2 = list2.pollFirst();
            if (node1.val == node2.val) {
                common = node1;
            } else {
                return common;
            }
        }
        return common;
    }

    // map保存父亲节点
}
