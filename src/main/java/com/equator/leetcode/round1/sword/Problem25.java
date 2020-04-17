package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/18 10:37
 **/

public class Problem25 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        merge();
    }

    public static void test() {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(3);
        head.next = listNode;
        listNode.next = null;
        print(head);
        change(head);
        print(head);
    }

    public static void change(ListNode head) {
        head.next = null;
    }

    public static void merge() {
        ListNode l1 = getL1(), l2 = getL2();
        ListNode head = new Problem25().mergeTwoLists(l1, l2);
        print(head);
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode getL1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(7);
        ListNode listNode5 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        return listNode1;
    }

    public static ListNode getL2() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(10);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        return listNode1;
    }
}
