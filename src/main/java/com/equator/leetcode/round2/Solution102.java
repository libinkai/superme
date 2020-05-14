package com.equator.leetcode.round2;

import com.equator.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/5/13 7:57
 **/

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new LinkedList<>();
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.pollFirst();
                item.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            ans.add(item);
        }
        return ans;
    }
}
