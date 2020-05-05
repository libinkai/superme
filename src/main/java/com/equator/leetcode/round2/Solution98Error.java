package com.equator.leetcode.round2;

import com.equator.leetcode.TreeNode;
import org.junit.Test;

/**
 * 局部合法
 *
 * @Author: Equator
 * @Date: 2020/5/5 13:31
 **/

public class Solution98Error {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (root.left != null && root.left.val >= root.val) {
                return false;
            }
            if (root.right != null && root.right.val <= root.val) {
                return false;
            }
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }
}
