package com.equator.datastruct.stack;

import com.equator.datastruct.array.MyGenericArray;
import com.equator.datastruct.array.MyStack;

/**
 * 实现一个泛型栈（利用动态数组）
 *
 * @Author: Equator
 * @Date: 2020/3/14 22:33
 **/

public class MyGenericStack<E> implements MyStack<E> {
    MyGenericArray<E> array;

    public MyGenericStack() {
        array = new MyGenericArray<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
