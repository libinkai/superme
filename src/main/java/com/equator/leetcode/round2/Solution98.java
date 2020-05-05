package com.equator.leetcode.round2;

import com.equator.leetcode.TreeNode;
import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/5 13:31
 **/

public class Solution98 {
    private long pre = Long.MIN_VALUE;

    // 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
