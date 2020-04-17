package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/20 22:36
 **/

public class Problem36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 全局变量保存上一次访问的结点
    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        convert(root);
        Node head = root, tail = root;
        while (head.left != null) {
            head = head.left;
        }
        while (tail.right != null) {
            tail = tail.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void convert(Node cur) {
        if (cur == null) {
            return;
        }
        convert(cur.left);
        cur.left = pre;
        if (pre != null) {
            pre.right = cur;
        }
        pre = cur;
        convert(cur.right);
    }
}
