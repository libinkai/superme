package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/2 23:00
 **/

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
