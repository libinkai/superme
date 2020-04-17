package com.equator.leetcode.round1;

import java.util.HashSet;

/**
 * @Author: Equator
 * @Date: 2020/1/16 7:26
 **/

public class Problem141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // hashset
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tempNode = head;
        while (tempNode != null) {
            if (set.contains(tempNode)) {
                return true;
            }
            set.add(tempNode);
            tempNode = tempNode.next;
        }
        return false;
    }

    // fast slow pointer 快慢指针
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = slow.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
