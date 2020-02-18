package com.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/18 11:11
 **/

public class Problem26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return travel(A, B);
    }

    public boolean travel(TreeNode A, TreeNode B) {
        if (A.left != null && travel(A.left, B)) {
            return true;
        }
        if (equal(A.val, B.val)) {
            if (judge(A, B)) {
                return true;
            }
        }
        if (A.right != null && travel(A.right, B)) {
            return true;
        }
        return false;
    }

    public boolean judge(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return equal(t1.val, t2.val) && judge(t1.left, t2.left) && judge(t1.right, t2.right);
    }

    public boolean equal(double a, double b) {
        if (Math.abs(a - b) < 1e-8) {
            return true;
        }
        return false;
    }
}
