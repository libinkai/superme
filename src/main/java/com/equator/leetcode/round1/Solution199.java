package com.equator.leetcode.round1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/4/22 10:42
 **/

public class Solution199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 层序遍历
    public List<Integer> rightSideView0(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.pollFirst();
                if (i == len - 1) {
                    res.add(node.val);
                }
                // 控制台输出还是很耗时的 System.out.println(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return res;
    }

    // 先遍历右子树再遍历左子树
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        travel(root, 0, res);
        return res;
    }

    private void travel(TreeNode root, int depth, List<Integer> res) {
        if (root != null) {
            if (res.size() == depth) {
                res.add(root.val);
            }
            travel(root.right, depth + 1, res);
            travel(root.left, depth + 1, res);
        }
    }
}
