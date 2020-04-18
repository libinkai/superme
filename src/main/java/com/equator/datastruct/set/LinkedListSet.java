package com.equator.datastruct.set;

import com.equator.datastruct.linkedlist.MyGenericLinkedList;
import com.equator.datastruct.linkedlist.MyGenericLinkedListWithDummyHead;

/**
 * @Author: Equator
 * @Date: 2020/4/18 11:54
 **/

public class LinkedListSet<E> implements MySet<E> {
    MyGenericLinkedListWithDummyHead<E> linkedList;


    public LinkedListSet() {
        linkedList = new MyGenericLinkedListWithDummyHead<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)){
            linkedList.addLast(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
