package com.leetcode;

import java.util.Stack;

/**
 * @Author: Equator
 * @Date: 2020/1/15 10:11
 **/

public class Problem206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // three pointer 三指针法
    public ListNode reverseList0(ListNode head) {
        if (head == null || head.next == null) {
            // null or single node linkedList
            return head;
        } else if (head.next.next == null) {
            // two node linkedList
            ListNode tempNode = head;
            head = head.next;
            head.next = tempNode;
            tempNode.next = null;
            return head;
        } else {
            ListNode leftPointer = head, middlePointer = head.next, rightPointer = middlePointer.next;
            while (rightPointer != null) {
                middlePointer.next = leftPointer;
                leftPointer = middlePointer;
                middlePointer = rightPointer;
                rightPointer = rightPointer.next;
            }
            head.next = null;
            middlePointer.next = leftPointer;
            return middlePointer;
        }
    }

    // stack
    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode tempNode = head, savedNode;
        while (tempNode != null) {
            savedNode = new ListNode(tempNode.val);
            nodeStack.push(savedNode);
            tempNode = tempNode.next;
        }
        if (nodeStack.empty()) {
            return head;
        }
        head = nodeStack.pop();
        tempNode = head;
        while (!nodeStack.empty()) {
            savedNode = nodeStack.pop();
            tempNode.next = savedNode;
            tempNode = tempNode.next;
        }
        return head;
    }

    // double pointer 双指针
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, cur = head, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归 recursion
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
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
        //ListNode head = null;
        head = new Problem206().reverseList(head);
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.val + "->");
            tempNode = tempNode.next;
        }
    }
}
