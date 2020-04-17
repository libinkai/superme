package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/20 7:36
 **/

public class Problem98 {


    /* 递归
    public boolean isValidBST(TreeNode root) {
        return travel(root, null, null);
    }

    public boolean travel(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if ((min != null && val <= min) || (max != null && val >= max)) {
            return false;
        }
        if (!(travel(root.left, min, val)) || !(travel(root.right, val, max))) {
            return false;
        }
        return true;
    } */



    /* 中序遍历 二叉搜索树的中序遍历是递增的
    public boolean isValidBST(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        travel(root, li);
        for (int i = 0; i < li.size() - 1; i++) {
            if (li.get(i) >= li.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void travel(TreeNode root, List<Integer> li) {
        if (root != null) {
            travel(root.left, li);
            li.add(root.val);
            travel(root.right, li);
        }
    } */

}
