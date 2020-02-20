package com.equator.leetcode.sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/20 18:03
 **/

public class Problem34 {
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        this.sum = sum;
        travel(root, ans, path, 0);
        return ans;
    }

    private void travel(TreeNode root, List<List<Integer>> ans, LinkedList<Integer> path, int current) {
        current += root.val;
        path.add(root.val);
        // 到达根节点并且等值
        if (current == sum && root.left == null && root.right == null) {
            List<Integer> item = new LinkedList<>();
            item.addAll(path);
            ans.add(item);
            path.removeLast();
            return;
        }
        if (root.left != null) {
            travel(root.left, ans, path, current);
        }
        if (root.right != null) {
            travel(root.right, ans, path, current);
        }
        path.removeLast();
    }
}
