package com.equator.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/2/27 21:22
 **/

public class Problem2 {
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        long a = getVal(l1);
        System.out.println(a);
        long b = getVal(l2);
        System.out.println(b);
        long sum = a + b;
        System.out.println(sum);
        if (sum == 0) {
            return new ListNode(0);
        }
        ListNode root = new ListNode(-1);
        ListNode p = root;
        while (sum != 0) {
            ListNode node = new ListNode((int) (sum % 10));
            p.next = node;
            p = p.next;
            sum /= 10;
        }
        return root.next;
    }

    private long getVal(ListNode root) {
        Deque<Integer> stack = new LinkedList<>();
        int val = 0;
        if (root.val != 0) {
            while (root != null) {
                stack.push(root.val);
                root = root.next;
            }
            while (!stack.isEmpty()) {
                val = val * 10 + stack.pop();
            }
        }
        return val;
    }*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode p1 = l1, last = null;
        while (p1 != null || l2 != null) {
            if (p1 == null) {
                p1 = l2;
                last.next = p1;
                l2 = null;
                continue;
            }
            if (l2 == null) {
                sum = p1.val + carry;
                carry = sum / 10;
                p1.val = sum % 10;
                last = p1;
                p1 = p1.next;
                continue;
            }
            sum = p1.val + l2.val + carry;
            carry = sum / 10;
            p1.val = sum % 10;
            last = p1;
            p1 = p1.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            p1 = new ListNode(carry);
            last.next = p1;
        }
        return l1;
    }
}
