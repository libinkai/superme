package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/20 18:42
 **/

public class Problem35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        cloneNodes(head);
        connectRandomNode(head);
        return reconnectNode(head);
    }

    // 将复制后的结点拼接在原结点之后
    public void cloneNodes(Node head) {
        Node p = head;
        while (p != null) {
            Node copyNode = new Node(p.val);
            copyNode.next = p.next;
            copyNode.random = null;
            p.next = copyNode;
            p = copyNode.next;
        }
    }

    // 连接随机结点
    public void connectRandomNode(Node head) {
        Node p = head;
        while (p != null) {
            Node copyNode = p.next;
            if (p.random != null) {
                copyNode.random = p.random.next;
            }
            p = copyNode.next;
        }
    }

    // 拆分链表
    public Node reconnectNode(Node head) {
        Node pNode = head;
        Node copyNodeHead = null, copyNode = null;
        if (pNode != null) {
            copyNodeHead = copyNode = pNode.next;
            pNode.next = copyNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            copyNode.next = pNode.next;
            copyNode = copyNode.next;
            pNode.next = copyNode.next;
            pNode = pNode.next;
        }
        return copyNodeHead;
    }
}
