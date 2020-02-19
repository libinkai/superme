package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/17 9:45
 **/

public class Problem21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 空头节点
        ListNode newListHead = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, tail = newListHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
        /*if (p1 != null) {
            do {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } while (p1 != null);
        }
        if (p2 != null) {
            do {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            } while (p2 != null);
        }*/
        //最后的合并如下优化：
        tail.next = p1 != null ? p1 : p2;
        return newListHead.next;
    }

    // 递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
