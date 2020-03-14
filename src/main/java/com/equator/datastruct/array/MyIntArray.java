package com.equator.datastruct.array;

import java.util.Arrays;

/**
 * 实现一个整形数组
 *
 * @Author: Equator
 * @Date: 2020/3/14 14:35
 **/

public class MyIntArray {
    int[] data;
    // size 既是数组的当前持有元素的数量，也是数组中第一个没有元素的索引
    private int size;

    // 创建指定容量大小的数组
    public MyIntArray(int capacity) {
        if (capacity > 0) {
            data = new int[capacity];
            size = 0;
        }
    }

    // 创建默认容量为16的数组
    public MyIntArray() {
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
    public void add(int index, int e) {
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

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public int get(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        data[index] = e;
    }

    public int index(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int e) {
        if (index(e) == -1) {
            return false;
        }
        return true;
    }

    public int remove(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("invalid index");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public void removeElement(int e) {
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
