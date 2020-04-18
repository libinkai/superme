package com.equator.datastruct.set;

/**
 * @Author: Equator
 * @Date: 2020/4/18 11:42
 **/

public interface MySet<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
