package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/20 13:12
 **/

public class Problem297 {
    public String serialize(TreeNode root) {
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        decode(vals, root, 1);
        return root;
    }

    public void decode(String[] vals, TreeNode root, int idx) {
        if (vals[idx].equals("null")) {
            root = null;
        } else {
            root.val = Integer.valueOf(vals[idx]);
            decode(vals, root.left, idx + 1);
            decode(vals, root.right, idx + 1);
        }
    }
}
