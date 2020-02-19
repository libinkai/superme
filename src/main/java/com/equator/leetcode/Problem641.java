package com.equator.leetcode;

import com.equator.datastruct.linkedlist.MyIntSingleLinkedList;

/**
 * @Author: Equator
 * @Date: 2020/1/19 7:28
 **/

public class Problem641 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class MyCircularDeque {
        private int capacity, size;

        private ListNode head, tail;

        public MyCircularDeque(int k) {
            if (k <= 0) {
                return;
            }
            capacity = k;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (head == null) {
                head = new ListNode(value);
                tail = head;
                head.next = tail;
                tail.next = head;
                size++;
                return true;
            }
            if (!isFull()) {
                ListNode newNode = new ListNode(value);
                newNode.next = head;
                tail.next = newNode;
                head = newNode;
                size++;
                return true;
            }
            return false;
        }


        public boolean insertLast(int value) {
            if (head == null) {
                head = new ListNode(value);
                tail = head;
                head.next = tail;
                tail.next = head;
                size++;
                return true;
            }
            if (!isFull()) {
                ListNode newNode = new ListNode(value);
                newNode.next = head;
                tail.next = newNode;
                tail = newNode;
                size++;
                return true;
            }
            return false;
        }

        public boolean deleteFront() {
            if (!isEmpty()) {
                if (size == 1) {
                    head = null;
                    tail = null;
                    size--;
                    return true;
                }
                tail.next = head.next;
                head = head.next;
                size--;
                return true;
            }
            return false;
        }

        public boolean deleteLast() {
            if (!isEmpty()) {
                if (size == 1) {
                    head = null;
                    tail = null;
                    size--;
                    return true;
                }
                ListNode tempNode = head;
                while (tempNode.next != tail) {
                    tempNode = tempNode.next;
                }
                tempNode.next = head;
                tail = tempNode;
                size--;
                return true;
            }
            return false;
        }

        public int getFront() {
            return head == null ? -1 : head.val;
        }

        public int getRear() {
            return tail == null ? -1 : tail.val;
        }

        public boolean isEmpty() {
            if (size != 0) {
                return false;
            }
            return true;
        }

        public boolean isFull() {
            if (size < capacity) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(8); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.insertFront(4);                    // 已经满了，返回 false
        circularDeque.getRear();                // 返回 2
        circularDeque.isFull();                        // 返回 true
        circularDeque.deleteLast();                    // 返回 true
        circularDeque.insertFront(4);                    // 返回 true
        circularDeque.getFront();                // 返回 4

    }

}
