package com.equator.datastruct.array;

import java.util.Arrays;

/**
 * 实现一个泛型数组
 *
 * @Author: Equator
 * @Date: 2020/3/14 14:35
 **/

public class MyGenericArray<E> {
    E[] data;
    // size 既是数组的当前持有元素的数量，也是数组中第一个没有元素的索引
    private int size;

    // 创建指定容量大小的数组
    public MyGenericArray(int capacity) {
        if (capacity > 0) {
            // 不支持这样的语法 data = new E[capacity];
            data = (E[]) new Object[capacity];
            size = 0;
        }
    }

    // 创建默认容量为16的数组
    public MyGenericArray() {
        this(16);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在指定位置插入元素
    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("array is full");
        }
        if (0 > index || index > size) {
            throw new IllegalArgumentException("invalid index");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        data[index] = e;
    }

    public int index(E e) {
        for (int i = 0; i < size; i++) {
            // 泛型数组，需要使用equals而不是==
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        if (index(e) == -1) {
            return false;
        }
        return true;
    }

    public E remove(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // help GC
        data[size] = null;
        size--;
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int idx = index(e);
        if (idx != -1) {
            remove(idx);
        }
    }

    @Override
    public String toString() {
        return "MyIntArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
