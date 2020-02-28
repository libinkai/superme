package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/28 18:13
 **/

public class Problem1038 {
    // 结果不需要是BST
    // BST 中序遍历 先遍历左子树->升序，先遍历右子树->降序
    int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        root.val += pre;
        pre = root.val;
        traverse(root.left);
    }
}
