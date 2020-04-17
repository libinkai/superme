package com.equator.leetcode.round1;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/19 21:00
 **/

public class Problem589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        travel(root, ans);
        return ans;
    }

    public void travel(Node root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            root.children.forEach(child -> travel(child, ans));
        }
    }
}
