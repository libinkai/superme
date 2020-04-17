package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/23 9:37
 **/

public class Problem52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        int sizeA = 0, sizeB = 0;
        while (pa != null) {
            sizeA++;
            pa = pa.next;
        }
        while (pb != null) {
            sizeB++;
            pb = pb.next;
        }
        int dif = sizeA > sizeB ? sizeA - sizeB : sizeB - sizeA;
        System.out.println(sizeA + " " + sizeB + " " + dif);
        pa = headA;
        pb = headB;
        if (sizeA > sizeB) {
            while (dif > 0) {
                pa = pa.next;
                dif--;
            }
        } else {
            while (dif > 0) {
                pb = pb.next;
                dif--;
            }
        }
        while (pa != null && pb != null) {
            if (pa.equals(pb)) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
