package com.equator.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/29 17:58
 **/

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node1 = list.poll();
            TreeNode node2 = list.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            // 画个图出来就很好理解了，怎么判断两棵树是不是对称的？树A的左子树等于B的右子树，树A的右子树等于树B的左子树
            list.add(node1.left);
            list.add(node2.right);
            list.add(node1.right);
            list.add(node2.left);
        }
        return true;
    }

    public boolean isSymmetric0(TreeNode root) {
        return rec(root, root);
    }

    private boolean rec(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val == r2.val) {
            return rec(r1.left, r2.right) && rec(r1.right, r2.left);
        }
        return false;
    }
}
