package org.review.leetcode.sword;

import com.equator.leetcode.ListNode;

/**
 * @Author: Equator
 * @Date: 2020/3/30 16:21
 **/

public class Solution62 {
    // 超时了，逻辑没问题 26/36
    public int lastRemaining0(int n, int m) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        int idx = 0, c = 1, remain = n;
        while (remain > 1) {
            if (nums[idx] != -1) {
                if (c == m) {
                    nums[idx] = -1;
                    remain--;
                    c = 1;
                } else {
                    c++;
                }
            }
            idx++;
            if (idx == n) {
                idx = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != -1) {
                return nums[i];
            }
        }
        return -1;
    }

    // 环形链表 ？？？
    public int lastRemaining1(int n, int m) {
        if (n <= 1) {
            return n;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head, newNode = null;
        for (int i = 1; i < n; i++) {
            newNode = new ListNode(i);
            cur.next = newNode;
            cur = newNode;
        }
        // 成环
        newNode.next = head;
        cur = head;
        int remain = n, c = 1;
        boolean isFirst = true;
        while (remain > 1) {
            if (isFirst) {
                if (c == m - 1) {
                    cur.next = cur.next.next;
                    isFirst = false;
                    c = 1;
                    remain--;
                    // cur = cur.next.next;
                } else {
                    c++;
                    cur = cur.next;
                }
            } else {
                if (c == m) {
                    cur.next = cur.next.next;
                    c = 1;
                    remain--;
                    // cur = cur.next.next;
                } else {
                    c++;
                    cur = cur.next;
                }
            }
        }
        return cur.val;
    }


    public static void main(String[] args) {
        System.out.println(new Solution62().lastRemaining1(10, 9));
    }
}
