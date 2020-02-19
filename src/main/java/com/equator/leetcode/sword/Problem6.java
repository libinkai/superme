package com.equator.leetcode.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/15 8:32
 **/

public class Problem6 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        rec(list, head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void rec(List<Integer> list, ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                rec(list, listNode.next);
            }
            list.add(listNode.val);
        }
    }
}
