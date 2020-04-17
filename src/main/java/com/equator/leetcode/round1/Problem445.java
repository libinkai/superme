package com.equator.leetcode.round1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/4/14 16:19
 **/

public class Problem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pollFirst();
            sum += stack2.isEmpty() ? 0 : stack2.pollFirst();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}
