package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/1/21 20:14
 **/

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length <= 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = getIndex(inorder, rootVal);
        int leftSize = rootIdx, rightSize = inorder.length - 1 - leftSize;
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, rootIdx + rightSize + 1);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + leftSize, leftSize + rightSize + 1);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }

    private int getIndex(int[] inorder, int rootValue) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                return i;
            }
        }
        return -1;
    }

    // 包头不包尾
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 2)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 0)));
    }

    @Test
    public void testMain() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }
}
