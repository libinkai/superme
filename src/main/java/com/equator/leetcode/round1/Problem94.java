package com.equator.leetcode.round1;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/19 20:37
 **/

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        travel(root, ans);
        return ans;
    }

    public void travel(TreeNode root, List<Integer> ans) {
        if (root != null) {
            travel(root.left, ans);
            ans.add(root.val);
            travel(root.right, ans);
        }
    }
}
