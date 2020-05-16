package com.equator.leetcode.round2;

import com.equator.leetcode.ListNode;

/**
 * @Author: Equator
 * @Date: 2020/5/16 7:52
 **/

public class Solution25 {

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode reverseInterval(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        // 确定一个区间
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseInterval(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
