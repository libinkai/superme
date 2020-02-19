package com.equator.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/19 20:53
 **/

public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        travel(root, ans);
        return ans;
    }

    public void travel(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            travel(root.left, ans);
            travel(root.right, ans);
        }
    }
}
