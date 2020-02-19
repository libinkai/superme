package com.equator.leetcode.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/2/15 8:49
 **/

public class Problem7 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> savedIndex = null;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length, inLen = inorder.length;
        if (preLen != inLen) {
            return null;
        }
        this.preorder = preorder;
        savedIndex = new HashMap<>(inLen);
        for (int i = 0; i < inorder.length; i++) {
            savedIndex.put(inorder[i], i);
        }
        return rec(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode rec(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = savedIndex.get(pivot);
        // pivotIndex - inL 是中序遍历数组中左子树区域的长度，也等于先序遍历数组中左子树的区域的长度
        root.left = rec(preL + 1, pivotIndex - inL + preL, inL, pivotIndex - 1);
        root.right = rec(pivotIndex - inL + preL + 1, preR, pivotIndex + 1, inR);
        return root;
    }
}
