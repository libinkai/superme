package com.equator.leetcode.sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/21 11:25
 **/

public class Problem37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> seq = new LinkedList<>();
        if (root != null) {
            serialize(seq, root);
        }
        return Arrays.toString(seq.toArray());
    }

    public void serialize(List<Integer> seq, TreeNode root) {
        if (root == null) {
            seq.add(null);
            return;
        }
        seq.add(root.val);
        serialize(seq, root.left);
        serialize(seq, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        String[] nodeArr = data.substring(1, data.length() - 1).split(",");
        for (String node : nodeArr) {
            nodes.add(node);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {
        String nodeStr = nodes.pollFirst();
        if ("null".equals(nodeStr.trim())) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodeStr.trim()));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5]";
        TreeNode root = new Problem37().deserialize(str);
        String sstr = new Problem37().serialize(root);
        System.out.println(sstr);
        TreeNode root2 = new Problem37().deserialize(sstr);
        String sstr2 = new Problem37().serialize(root2);
        System.out.println(sstr2);
    }
}
