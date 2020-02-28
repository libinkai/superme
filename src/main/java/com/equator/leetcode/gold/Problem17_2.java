package com.equator.leetcode.gold;

import com.equator.leetcode.TreeNode;

/**
 * @Author: Equator
 * @Date: 2020/2/28 10:47
 **/

public class Problem17_2 {
    TreeNode pre;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        travel(root);
        return head;
    }

    public void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        if (pre != null) {
            pre.right = root;
        }
        root.left = null;
        pre = root;
        travel(root.right);
    }
}
