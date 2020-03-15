package com.equator.datastruct.linkedlist;

/**
 * 实现一个泛型链表
 *
 * @Author: Equator
 * @Date: 2020/3/15 11:21
 **/

public class MyGenericLinkedList<E> {
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

    private Node head;
    private int size;

    public MyGenericLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在头部插入节点
    public void addFirst(E e) {
        /* 等价于
        Node node = new Node(e);
        node.next = head;
        head = node;
        */
        head = new Node(e, head);
        size++;
    }

    // 在指定的“索引”插入元素（从0开始，0需要特殊处理）
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            /* 等价于
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            */
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }


}
