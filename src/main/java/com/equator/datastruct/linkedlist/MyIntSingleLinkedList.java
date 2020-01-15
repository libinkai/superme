package com.equator.datastruct.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/1/15 9:16
 **/

public class MyIntSingleLinkedList {
    class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    // 头指针中保存链表的长度
    private Node head = new Node(0);

    // 追加
    public void append(Integer val) {
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        Node newNode = new Node(val);
        newNode.next = null;
        tempNode.next = newNode;
        head.value++;
    }

    // 在指定位置添加
    public boolean add(int index, Integer val) {
        if (index > head.value) {
            return false;
        }
        Node leftTempNode = head, rightTempNode;
        for (int i = 0; i < index; i++) {
            leftTempNode = leftTempNode.next;
        }
        rightTempNode = leftTempNode.next;
        Node newNode = new Node(val);
        newNode.next = rightTempNode;
        leftTempNode.next = newNode;
        head.value++;
        return true;
    }

    public boolean delete(int index) {
        if (index >= head.value) {
            return false;
        }
        Node leftTempNode = head, rightTempNode;
        for (int i = 0; i < index; i++) {
            leftTempNode = leftTempNode.next;
        }
        rightTempNode = leftTempNode.next.next;
        leftTempNode.next = rightTempNode;
        head.value--;
        // help gc
        System.gc();
        return true;
    }

    // 打印
    public void print() {
        Node tempNode = head.next;
        System.out.print("链表长度：" + head.value + "\t链表内容：");
        while (tempNode != null) {
            System.out.print(tempNode.value + "-->");
            tempNode = tempNode.next;
        }
    }

    public void testAppend() {
        MyIntSingleLinkedList linkedList = new MyIntSingleLinkedList();
        linkedList.append(1);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.print();
    }

    public void testAdd() {
        MyIntSingleLinkedList linkedList = new MyIntSingleLinkedList();
        linkedList.append(1);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.add(5, 4);
        linkedList.print();
    }

    public void testDelete() {
        MyIntSingleLinkedList linkedList = new MyIntSingleLinkedList();
        linkedList.append(1);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.delete(1);
        linkedList.print();
    }

    public static void main(String[] args) {
        new MyIntSingleLinkedList().testDelete();
    }
}
