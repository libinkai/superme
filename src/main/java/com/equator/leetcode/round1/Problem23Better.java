package com.equator.leetcode.round1;

/**
 * 两两比较, 时间复杂度：O(NlogK)
 *
 * @Author: Equator
 * @Date: 2020/4/26 15:07
 **/

public class Problem23Better {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int mid = (low + high) / 2;
        return mergeTwoLists(merge(lists, low, mid), merge(lists, mid + 1, high));
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
