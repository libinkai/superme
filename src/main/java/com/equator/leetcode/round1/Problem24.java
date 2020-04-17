package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/15 17:29
 **/

public class Problem24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 双指针
    public ListNode swapPairs0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode left = head, right = left.next, temp;
        while (right != null) {
            temp = right.next;
            if (temp == null) {
                // 偶数节点末尾
                right.next = left;
                left.next = null;
                return newHead;
            }
            // 中部
            right.next = left;
            if (temp.next == null) {
                // 奇数节点末尾
                left.next = temp;
                temp.next = null;
                return newHead;
            }
            left.next = temp.next;
            left = temp;
            right = left.next;
        }
        left.next = null;
        return newHead;
    }

    // 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static ListNode getOddList() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        return head;
    }

    public static ListNode getEvenList() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = getOddList();
        head = new Problem24().swapPairs(head);
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.val + "->");
            tempNode = tempNode.next;
        }
    }
}
