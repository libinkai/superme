package com.equator.leetcode.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/2/20 11:51
 **/

public class Problem32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.pollFirst();
                if (level % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            ans.add(temp);
            level++;
        }
        return ans;
    }
}
