package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/22 21:41
 **/

public class Problem515 {
    // BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 0;
        while (deque.size() != 0) {
            int levelSize = deque.size(), max = deque.getFirst().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.pollFirst();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            ans.add(max);
            level++;
        }
        return ans;
    }
}
