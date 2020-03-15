package com.equator.datastruct.stack;

/**
 * @Author: Equator
 * @Date: 2020/3/14 22:47
 **/

public interface MyStack<E> {

    public void push(E e);

    public E pop();

    public E peek();

    public int getSize();

    public boolean isEmpty();
}
