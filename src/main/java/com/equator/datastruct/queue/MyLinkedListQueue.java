package com.equator.datastruct.queue;

import com.equator.datastruct.linkedlist.MyGenericLinkedListWithDummyHead;

/**
 * @Author: Equator
 * @Date: 2020/3/15 14:13
 **/

public class MyLinkedListQueue<E> implements MyQueue<E> {
    // 节点内部类
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head, tail;
    private int size;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        Node headNode = head;
        head = head.next;
        headNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return headNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
