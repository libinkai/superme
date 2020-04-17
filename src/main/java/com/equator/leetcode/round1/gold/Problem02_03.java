package com.equator.leetcode.round1.gold;

import com.equator.leetcode.round1.ListNode;

/**
 * @Author: Equator
 * @Date: 2020/3/24 8:48
 **/

public class Problem02_03 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
