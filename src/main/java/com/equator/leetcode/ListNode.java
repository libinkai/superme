package com.equator.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/23 9:37
 **/

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode listNodeWrapper(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            p.next = node;
            p = node;
        }
        return dummyHead.next;
    }

    public static String print(ListNode head) {
        ListNode p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.val);
            sb.append("->");
            p = p.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 8};
        ListNode list = listNodeWrapper(nums);
    }
}
