package com.equator.leetcode.round1.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/20 11:38
 **/

public class Problem32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> ans = travel(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.remove(0);
        }
        return res;
    }

    public List<Integer> travel(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode first = deque.pollFirst();
            if (first.left != null) {
                deque.addLast(first.left);
            }
            if (first.right != null) {
                deque.addLast(first.right);
            }
            ans.add(first.val);
        }
        return ans;
    }
}
