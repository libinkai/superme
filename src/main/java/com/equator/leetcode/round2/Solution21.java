package com.equator.leetcode.round2;

import com.equator.leetcode.ListNode;
import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/1 21:27
 **/

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = merge(l1, l2);
        return head.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test() {
        ListNode list1 = ListNode.listNodeWrapper(new int[]{1, 2, 4});
        ListNode list2 = ListNode.listNodeWrapper(new int[]{1, 3, 4});
        ListNode list = mergeTwoLists(list1, list2);
        System.out.println(ListNode.print(list));
    }
}
