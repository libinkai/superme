package com.equator.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/22 17:57
 **/

public class Problem102 {
    // [1,2,3,4,5] 错误
    public List<List<Integer>> levelOrder0(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        travel0(ans, new LinkedList<>(), deque);
        return ans;
    }

    public void travel0(List<List<Integer>> ans, List<Integer> ansItem, Deque<TreeNode> deque) {
        while (deque.size() > 0) {
            TreeNode node = deque.pollFirst();
            ansItem.add(node.val);
            if (deque.size() == 0) {
                ans.add(ansItem);
                ansItem = new LinkedList<>();
            }
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
            travel0(ans, ansItem, deque);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 0;
        while (deque.size() != 0) {
            ans.add(new LinkedList<>());
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.pollFirst();
                ans.get(level).add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            level++;
        }
        return ans;
    }
}
