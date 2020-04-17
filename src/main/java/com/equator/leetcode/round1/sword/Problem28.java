package com.equator.leetcode.round1.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/19 8:47
 **/

public class Problem28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> preorderSeq = preorder(new LinkedList<>(), root);
        List<Integer> symmetricPreorderSeq = symmetricPreorder(new LinkedList<>(), root);
        while (preorderSeq.size() != 0 && symmetricPreorderSeq.size() != 0) {
            Integer preorder = preorderSeq.remove(0);
            Integer symmetricPreorder = symmetricPreorderSeq.remove(0);
            if (preorder == null && symmetricPreorder == null) {
                continue;
            }
            if (preorder == null && symmetricPreorder != null) {
                return false;
            }
            if (preorder != null && symmetricPreorder == null) {
                return false;
            }
            if (!preorder.equals(symmetricPreorder)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> preorder(List<Integer> seq, TreeNode root) {
        seq.add(root.val);
        if (root.left != null) {
            preorder(seq, root.left);
        } else {
            // 需要添加空节点，否则有些二叉树不能识别
            seq.add(null);
        }
        if (root.right != null) {
            preorder(seq, root.right);
        } else {
            seq.add(null);
        }
        return seq;
    }

    public List<Integer> symmetricPreorder(List<Integer> seq, TreeNode root) {
        seq.add(root.val);
        if (root.right != null) {
            symmetricPreorder(seq, root.right);
        } else {
            seq.add(null);
        }
        if (root.left != null) {
            symmetricPreorder(seq, root.left);
        } else {
            seq.add(null);
        }
        return seq;
    }
}
