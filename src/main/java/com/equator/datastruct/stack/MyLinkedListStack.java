package com.equator.datastruct.stack;

import com.equator.datastruct.linkedlist.MyGenericLinkedList;
import com.equator.datastruct.linkedlist.MyGenericLinkedListWithDummyHead;

/**
 * @Author: Equator
 * @Date: 2020/3/15 15:48
 **/

public class MyLinkedListStack<E> implements MyStack<E> {
    MyGenericLinkedListWithDummyHead<E> linkedList;

    public MyLinkedListStack() {
        linkedList = new MyGenericLinkedListWithDummyHead<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
