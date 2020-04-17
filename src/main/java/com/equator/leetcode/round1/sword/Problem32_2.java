package com.equator.leetcode.round1.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/20 11:51
 **/

public class Problem32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
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
