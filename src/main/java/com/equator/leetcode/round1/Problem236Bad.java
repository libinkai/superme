package com.equator.leetcode.round1;

import java.util.LinkedList;
import java.util.List;

/**
 * 运行超时，逻辑没问题
 *
 * @Author: Equator
 * @Date: 2020/1/20 17:01
 **/

public class Problem236Bad {
    class NodeFinder {
        private List<TreeNode> list = new LinkedList<>();

        public List<TreeNode> findNode(TreeNode root, TreeNode target) {
            dfs(root, target, new LinkedList<>());
            return list;
        }

        private void dfs(TreeNode root, TreeNode target, List<TreeNode> list) {
            list.add(root);
            if (root.val == target.val) {
                this.list = list;
                return;
            }
            if (root.left != null) {
                dfs(root.left, target, new LinkedList<>(list));
            }
            if (root.right != null) {
                dfs(root.right, target, new LinkedList<>(list));
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        NodeFinder nodeFinder1 = new NodeFinder();
        List<TreeNode> list1 = nodeFinder1.findNode(root, p);
        NodeFinder nodeFinder2 = new NodeFinder();
        List<TreeNode> list2 = nodeFinder2.findNode(root, q);
        TreeNode common = null;
        while (list1.size() > 0 && list2.size() > 0) {
            TreeNode node1 = list1.remove(0);
            TreeNode node2 = list2.remove(0);
            if (node1.val == node2.val) {
                common = node1;
            } else {
                return common;
            }
        }
        return common;
    }
}
