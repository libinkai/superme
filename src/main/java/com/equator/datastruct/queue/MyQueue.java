package com.equator.datastruct.queue;

/**
 * @Author: Equator
 * @Date: 2020/3/15 7:38
 **/

public interface MyQueue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
