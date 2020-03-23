package com.equator.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/3/23 7:50
 **/

public class Problem876 {
    // 数组
    public ListNode middleNode0(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            arr.add(p);
            p = p.next;
        }
        int len = arr.size();
        return arr.get(len / 2);
    }

    // 单指针
    public ListNode middleNode1(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int mid = len / 2;
        p = head;
        while (mid > 0) {
            p = p.next;
            mid--;
        }
        return p;
    }

    // 快慢指针，访问链表之间的某个节点时常用
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
