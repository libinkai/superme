package com.equator.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/1/16 7:26
 **/

public class Problem142 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //
    public ListNode hasCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode flag = head, slow, fast;
        while (flag != null) {
            slow = flag;
            fast = slow.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return null;
                } else if (slow == flag) {
                    return flag;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            if (slow == flag) {
                return flag;
            }
            flag = flag.next;
        }
        return null;
    }

    // hash
    public ListNode hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

    public static ListNode getNoCycleList() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return head;
    }

    public static ListNode getCycleList() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        return head;
    }

    public static ListNode getSingleNodeList() {
        ListNode head = new ListNode(1);
        head.next = head;
        return head;
    }

    public static ListNode getSelfNodeList() {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = getSelfNodeList();
        ListNode res = new Problem142().hasCycle1(head);
        System.out.println(res.val);
    }
}
