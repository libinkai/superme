package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/18 7:36
 **/

public class Problem18 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode h = head, last = null, temp = null;
        if (h.val == val) {
            head = head.next;
            return head;
        }
        while (h != null && h.val != val) {
            last = h;
            h = h.next;
        }
        // not found
        if (h == null) {
            return head;
        }
        last.next = h.next;
        h = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        print(new Problem18().deleteNode(listNode1, 9));
    }

    public static void print(final ListNode head) {
        ListNode h = head;
        while (h != null) {
            System.out.println(h.val + "->");
            h = h.next;
        }
    }
}
