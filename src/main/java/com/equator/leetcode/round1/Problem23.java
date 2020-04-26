package com.equator.leetcode.round1;

/**
 * 逐一合并两条链表, 时间复杂度：O(NK)
 *
 * @Author: Equator
 * @Date: 2020/4/26 15:07
 **/

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode list : lists) {
            head = mergeTwoLists(head, list);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
